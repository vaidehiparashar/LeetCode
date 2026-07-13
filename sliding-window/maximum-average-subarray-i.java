class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int i=0, j=k-1;
        double ans = -Double.MAX_VALUE;
        int sum = 0, n = arr.length;
        for(int x=0;x<=j;x++) {
            sum += arr[x];
        }

        while(j<n) {
            double avg = (double)sum/(double)k;
            i++;j++;
            if(j<n)sum += arr[j];
            sum -= arr[i-1];
            ans = Math.max(avg,ans);
        }
        return ans;
    }
}