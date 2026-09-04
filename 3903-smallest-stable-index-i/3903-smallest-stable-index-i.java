class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // T.C = O(n), S.C = O(n)

        int n = nums.length;

        int[] minFromIndex = new int[n];

        int minEl = Integer.MAX_VALUE;

        // Build suffix minimum array
        for(int i = n - 1; i >= 0; i--) {

            minEl = Math.min(minEl, nums[i]);
            minFromIndex[i] = minEl;
        }

        int maxEl = Integer.MIN_VALUE;

        // Traverse from left to right
        for(int i = 0; i < n; i++) {

            maxEl = Math.max(maxEl, nums[i]);

            minEl = minFromIndex[i];

            if(maxEl - minEl <= k) {
                return i;
            }
        }

        return -1;
    }
}