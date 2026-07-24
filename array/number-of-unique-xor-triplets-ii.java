class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        for (int k = j; k < n; k++) {
            int xor = nums[i] ^ nums[j] ^ nums[k];
            set.add(xor);
        }
    }
}

return set.size();
        
    }
}