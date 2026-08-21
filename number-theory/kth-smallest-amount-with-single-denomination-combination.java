import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        java.util.function.LongPredicate check = (m) -> {
            long total = 0;

            for (int mask = 1; mask < (1 << coins.length); mask++) {
                long l = 1;
                int bits = 0;

                for (int i = 0; i < coins.length; i++) {
                    if ((mask & (1 << i)) != 0) {
                        l = lcm(l, coins[i]);
                        bits++;
                        
                        if (l > m) break;
                    }
                }

                if (l <= m) {
                    long count = m / l;

                    if (bits % 2 == 1)
                        total += count;
                    else
                        total -= count;
                }
            }

            return total >= k;
        };

        long lo = 1;
        long hi = (long) k * coins[0];

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (check.test(mid))
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}