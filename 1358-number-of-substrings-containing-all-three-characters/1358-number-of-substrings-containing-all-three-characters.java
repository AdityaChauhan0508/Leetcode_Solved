class Solution {
    public int numberOfSubstrings(String s) {

        int left = 0;
        int ans = 0;
        int[] freq = new int[3]; // freq[0]=a, freq[1]=b, freq[2]=c

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            freq[s.charAt(right) - 'a']++;

            // If window contains all a, b and c
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // All substrings ending after 'right' are also valid
                ans += s.length() - right;

                // Remove left character from window
                freq[s.charAt(left) - 'a']--;

                // Shrink the window
                left++;
            }
        }

        return ans;
    }
}