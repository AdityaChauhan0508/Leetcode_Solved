class Solution {
    public String removeKdigits(String num, int k) {

        if(num.length() <= 0) return "0";

        Stack<Character> st = new Stack<>();

        //Build a monotonic stack
        for(int i=0; i<num.length(); i++) {
            char digit = num.charAt(i);

            while(!st.isEmpty() && k > 0 && digit < st.peek()) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        //Remove remaining digit from the end
        while(k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        //Build the result in reverse order
        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();

        //Remove leading zeroes
        int index = 0; 

        while(index < result.length() && result.charAt(index) == '0') {
            index++;
        }

        if(index == result.length()) {
            return "0";
        }

        return result.substring(index);
    }
}