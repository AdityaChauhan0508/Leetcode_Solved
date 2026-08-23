class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int leftKnownSum = 0, rightKnownSum = 0;
        int leftQnMarkCount = 0, rightQnMarkCount = 0;

        for (int i = 0; i < n; i++) {

            if (num.charAt(i) == '?') {

                if (i < n / 2) {
                    leftQnMarkCount++;
                } else {
                    rightQnMarkCount++;
                }

            } else {

                if (i < n / 2) {
                    leftKnownSum += num.charAt(i) - '0';
                } else {
                    rightKnownSum += num.charAt(i) - '0';
                }
            }
        }

        int totalQnMark = leftQnMarkCount + rightQnMarkCount;

        // Odd number of '?' -> Alice wins
        if (totalQnMark % 2 == 1) {
            return true;
        }

        int left = 2 * leftKnownSum + 9 * leftQnMarkCount;
        int right = 2 * rightKnownSum + 9 * rightQnMarkCount;

        // If equal, Bob can make the sums equal
        if (left == right) {
            return false;
        }

        // Otherwise Alice wins
        return true;
    }
}