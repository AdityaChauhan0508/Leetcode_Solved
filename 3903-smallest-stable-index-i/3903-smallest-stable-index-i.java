class Solution {
    public int firstStableIndex(int[] nums, int k) {

        //Brute force Approach T.C = O(n^2)

        int n = nums.length;
        for(int i=0; i<n; i++) {

            int maxEl = Integer.MIN_VALUE;
            int minEl = Integer.MAX_VALUE;

            for(int j=0; j<=i; j++) {
                maxEl = Math.max(maxEl, nums[j]);
            }

            for(int j=i; j<=n-1; j++) {
                minEl = Math.min(minEl, nums[j]);
            }

            if(maxEl - minEl <= k) {
                return i;
            }
            
        }
        return -1;
    }
}