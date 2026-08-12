class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put ( '(' , ')');
        mapping.put('{' , '}');
        mapping.put( '[' , ']');
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if(mapping.containsValue(c)){
                stack.push(c);
                else if (mapping.containsKey(c)) {
        if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
            return false;
            }
        }
    }
    return stack.isEmpty();
}
    }