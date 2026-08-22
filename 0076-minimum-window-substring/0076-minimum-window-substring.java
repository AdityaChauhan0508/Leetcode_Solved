class Solution {
    public String minWindow(String s, String t) {
        //O(m + n) time and O(1) extra space when using a fixed 128/256-character frequency array.

        if(s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        for(char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0, right ,start = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;

        for(right = 0 ; right < s.length(); right++) {

            char ch = s.charAt(right);

            //if this ch(character) is required
            if(freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            //Current window contain all character of t 
            while(count == 0) {

                //Update minimum window
                if(right - left + 1 < minLen) {
                    minLen = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                // Removing a required character makes window invalid
                if (freq[leftChar] > 0) {
                    count++;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }
}