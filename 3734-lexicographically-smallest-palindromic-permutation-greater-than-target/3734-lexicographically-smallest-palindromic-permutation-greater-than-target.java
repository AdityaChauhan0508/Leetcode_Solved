class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count frequency
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check odd frequencies
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        // More than one odd frequency => palindrome impossible
        if (oddCount > 1) {
            return "";
        }

        // Characters available for left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        StringBuilder prefix = new StringBuilder();

        // Build left half greedily
        for (int pos = 0; pos < halfLen; pos++) {

            boolean found = false;

            // Try smallest character first
            for (int c = 0; c < 26; c++) {

                if (halfFreq[c] == 0) {
                    continue;
                }

                // Choose character
                halfFreq[c]--;
                prefix.append((char) ('a' + c));

                // Can we still make a palindrome > target?
                if (canMakeGreater(prefix, halfFreq, middle, target)) {
                    found = true;
                    break;
                }

                // Undo
                prefix.deleteCharAt(prefix.length() - 1);
                halfFreq[c]++;
            }

            if (!found) {
                return "";
            }
        }

        String answer = buildPalindrome(prefix.toString(), middle);

        // IMPORTANT:
        // The answer must be strictly greater than target.
        if (answer.compareTo(target) <= 0) {
            return "";
        }

        return answer;
    }


    private boolean canMakeGreater(
            StringBuilder prefix,
            int[] halfFreq,
            char middle,
            String target) {

        StringBuilder left = new StringBuilder(prefix);

        // Make the LARGEST possible remaining left half
        for (int c = 25; c >= 0; c--) {

            for (int j = 0; j < halfFreq[c]; j++) {
                left.append((char) ('a' + c));
            }
        }

        String palindrome = buildPalindrome(left.toString(), middle);

        return palindrome.compareTo(target) > 0;
    }


    private String buildPalindrome(String left, char middle) {

        StringBuilder result = new StringBuilder();

        // Left half
        result.append(left);

        // Middle character
        if (middle != 0) {
            result.append(middle);
        }

        // Reverse of left half
        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}