class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    set.add(nums[i] ^ nums[j] ^ nums[k]);
                }
            }
        }

        return set.size();
    }
}