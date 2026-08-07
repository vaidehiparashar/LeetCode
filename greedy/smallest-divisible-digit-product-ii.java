class Solution {

    String num; 
    int allowedPrimes[] = {2, 3, 5, 7}; 
    private boolean isReqMet(int[] freq) {
        for(int p: allowedPrimes) {
            if(freq[p] > 0) return false; 
        }
        return true; 
    }
    private StringBuilder getNum(int[] freq, int pos, int len, StringBuilder cur, boolean flag) {

        if (pos == len) {
            if (isReqMet(freq))
                return cur;
            return null;
        }
        for(int i = 1; i <= 9; i++) {
            char c = (char)('0' + i); 
            if (!flag && pos < num.length() && c < num.charAt(pos))
                continue; 
            int curFreq[] = freq.clone(); 
            for(int _p: allowedPrimes) {
                int t = i; 
                while(t % _p == 0) {
                    curFreq[_p]--; 
                    t/=_p; 
                } 
                curFreq[_p] = Math.max(0, curFreq[_p]); 
            } 
            cur.append(c); 
            StringBuilder res = getNum(curFreq, pos + 1, len, cur, flag || (pos < num.length() && num.charAt(pos) < c)); 
            if(res != null) return res; 
            // backtrack 
            cur.deleteCharAt(cur.length() - 1); 
        }

        
        return null; 
    }
    public String smallestNumber(String num, long t) {
        this.num = num; 
        int freq[] = new int[10]; 
        for(int p: allowedPrimes) {
            while(t % p == 0) {
                freq[p]++; 
                t/= p; 
            }
        }

        if(t > 1) return "-1"; 
        StringBuilder ans = new StringBuilder(); 
        for(int i = num.length(); i < num.length() + 10; i++) {
            StringBuilder res = getNum(freq, 0, i, ans, i > num.length() ? true :false); // [freq, pos] 
            if(res != null) return res.toString(); 
        }
        
        return "-1"; 
    }
}