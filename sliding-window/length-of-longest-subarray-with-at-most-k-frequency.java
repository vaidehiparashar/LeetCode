class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int r = 1;
        for(int left = 0; left<n; left++){
            HashMap<Integer ,Integer> freq = new HahMap<>();
            for(int right = left; right < n; rigth++){
                int c = nums[rigtht];
                freq.put(c, freq.getOrDefault(c,0)+1));
                if(freq.put(c)>k) break;
                r = Math.max(r, rigth - left+1);
                            }      
                  }
        }
        return r;
        
    }
}