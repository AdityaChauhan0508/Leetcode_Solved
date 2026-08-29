class Solution {
    public int strongPasswordChecker(String password) {

        int n = password.length();

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        // Check character types
        for (char c : password.toCharArray()) {

            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        int missingTypes =
                (hasLower ? 0 : 1) +
                (hasUpper ? 0 : 1) +
                (hasDigit ? 0 : 1);

        // Count replacements required for consecutive characters
        int replacementsNeeded = 0;

        // rem[0] -> runs where length % 3 == 0
        // rem[1] -> runs where length % 3 == 1
        // rem[2] -> runs where length % 3 == 2
        int[] rem = new int[3];

        int i = 0;

        while (i < n) {

            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {

                replacementsNeeded += len / 3;

                rem[len % 3]++;
            }

            i = j;
        }

        // Case 1: Password is too short
        if (n < 6) {

            int insertionNeeded = 6 - n;

            return Math.max(insertionNeeded, missingTypes);
        }

        // Case 2: Password length is valid
        else if (n <= 20) {

            return Math.max(missingTypes, replacementsNeeded);
        }

        // Case 3: Password is too long
        else {

            int deletionNeeded = n - 20;

            int remainingDeletions = deletionNeeded;

            int replacements = replacementsNeeded;

            // First: delete from runs where len % 3 == 0
            int use = Math.min(remainingDeletions, rem[0]);

            replacements -= use;
            remainingDeletions -= use;

            // Second: delete 2 characters from runs where len % 3 == 1
            use = Math.min(remainingDeletions / 2, rem[1]);

            replacements -= use;
            remainingDeletions -= use * 2;

            // Third: delete 3 characters from remaining runs
            use = Math.min(remainingDeletions / 3, replacements);

            replacements -= use;

            return deletionNeeded + Math.max(missingTypes, replacements);
        }
    }
}