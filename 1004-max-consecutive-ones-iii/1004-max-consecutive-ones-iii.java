class Solution {
    public int longestOnes(int[] nums, int k) {

        return maxConsecutive(nums, k , 1);
        
    }

     private int maxConsecutive(int[] nums, int k, int target) {
        int left = 0;
        int changes = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // If current character is not target,
            // we need to change it.
            if (nums[right] != target) {
                changes++;
            }

            // More than k changes -> shrink window
            while (changes > k) {
                if (nums[left] != target) {
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