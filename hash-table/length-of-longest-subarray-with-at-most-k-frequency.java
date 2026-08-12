class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int r = 1;
        for (int left = 0; left < n; left++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int right = left; right < n; right++) {
                int c = nums[right];
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                if (freq.get(c) > k) break;
                r = Math.max(r, right - left + 1);
            }
        }
        return r;
    }
}