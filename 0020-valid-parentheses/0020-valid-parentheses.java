class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        char[] ch = s.toCharArray();

        for(int i=0; i<s.length(); i++) {

            if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                st.push(ch[i]);
            } else{
                if(st.isEmpty()) {
                    return false;
                }
                if((ch[i] == ')' && st.peek() == '(') ||
                   (ch[i] == ']' && st.peek() == '[') ||
                   (ch[i] == '}' && st.peek() == '{')) {
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}