class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> mapping = new HashMap<>();

        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (mapping.containsValue(c)) {
                stack.push(c);
            } 
            else if (mapping.containsKey(c)) {

                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}