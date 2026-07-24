class Solution {
    public int uniqueXorTriplets(int[] nums) {

        boolean[] present = new boolean[2048];
        for (int x : nums) {
            present[x] = true;
        }
        int[] values = new int[2048];
        int m = 0;
        for (int i = 0; i < 2048; i++) {
            if (present[i]) {
                values[m++] = i;
            }
        }
        boolean[] pairXor = new boolean[2048];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                pairXor[values[i] ^ values[j]] = true;
            }
        }
        boolean[] ans = new boolean[2048];

        for (int x = 0; x < 2048; x++) {
            if (!pairXor[x]) continue;

            for (int i = 0; i < m; i++) {
                ans[x ^ values[i]] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}