class Solution {
    public int rob(int[] nums) { //time = O(n), space = O(1) {space optimization}

        int n = nums.length;

        if(n == 1) return nums[0];

        int prev1 = nums[0];
        int prev2 = Math.max(nums[0] , nums[1]);

        int result = prev2;

        for(int i=2; i<n; i++) {
            result = Math.max(prev2 , prev1 + nums[i]);

            prev1 = prev2;
            prev2 = result;
        }
        
        return result;
    }
}