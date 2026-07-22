class Solution {
    public boolean canFinish(int n, int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int []in=new int[n];
        for(int edge[]:graph){
            int u=edge[0];
            int v=edge[1];
            in[u]+=1;
            adj.get(v).add(u);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer>ans=new ArrayList<>();
		
		for (int i = 0; i<n; i++) {
			if (in[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int val = q.poll();
			ans.add(val);
			
			for (int i = 0; i<adj.get(val).size(); i++) {
				int neighbour = adj.get(val).get(i);
				in[neighbour] -= 1;
				
				if (in[neighbour] == 0) {
					q.offer(neighbour);
				}
			}
		}
		return (ans.size()==n);
    }
}