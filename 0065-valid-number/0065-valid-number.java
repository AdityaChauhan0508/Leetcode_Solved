class Solution {
    public boolean isNumber(String s) {
        // 1. Trim leading and trailing whitespace
        s = s.trim();

        // If the string is empty after trimming, it's not a valid number.
        if (s.isEmpty()) {
            return false;
        }

        boolean seenDigit = false;      // True if we have encountered any digit
        boolean seenDot = false;        // True if we have encountered a decimal point '.'
        boolean seenExponent = false;   // True if we have encountered an exponent 'e' or 'E'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true; // Found a digit, valid
            } else if (c == '.') {
                // A dot is invalid if:
                // 1. We've already seen a dot (multiple dots).
                // 2. We've already seen an exponent ('e' or 'E') (dot cannot appear after 'e').
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true; // Mark that we've seen a dot
            } else if (c == 'e' || c == 'E') {
                // An exponent 'e'/'E' is invalid if:
                // 1. We've already seen an exponent (multiple 'e's).
                // 2. We haven't seen any digit before it (exponent must follow a number).
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true; // Mark that we've seen an exponent
                // Reset seenDigit because we need to see at least one digit *after* 'e'
                // for the exponent part to be valid (e.g., "2e", "e" are invalid).
                seenDigit = false; 
            } else if (c == '+' || c == '-') {
                // A sign '+' or '-' is invalid if:
                // 1. It's not at the beginning of the string (i != 0).
                // 2. AND it's not immediately after an exponent 'e' or 'E'.
                // Signs can only appear at the start of the number or the start of the exponent part.
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                // Any other character is invalid.
                return false;
            }
        }

        // After iterating through the entire string, we must have seen at least one digit.
        // This implicitly handles cases like ".", "e", "+", "-" which are not numbers.
        // It also ensures that if an exponent was present, there was at least one digit after it
        // because seenDigit was reset after 'e' and must have become true again.
        return seenDigit;
    }
}