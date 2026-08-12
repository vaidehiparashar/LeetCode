class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            int c = nums[right];
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.get(c) > k) {

                int leftElement = nums[left];

                freq.put(leftElement, freq.get(leftElement) - 1);

                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}