class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(
            maxConsecutive(answerKey, k, 'T'),
            maxConsecutive(answerKey, k, 'F')
        );
    }

    private int maxConsecutive(String s, int k, char target) {
        int left = 0;
        int changes = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // If current character is not target,
            // we need to change it.
            if (s.charAt(right) != target) {
                changes++;
            }

            // More than k changes -> shrink window
            while (changes > k) {
                if (s.charAt(left) != target) {
                    changes--;
                }
                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}