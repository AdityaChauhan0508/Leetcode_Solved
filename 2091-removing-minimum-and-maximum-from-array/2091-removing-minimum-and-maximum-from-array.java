class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;

        int minIdx = 0;
        int maxIdx = 0;

        //to find the min and max element
        for(int i= 1; i<n; i++) {

            if(nums[i] < nums[minIdx]) {
                minIdx = i;
            }

            if(nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        //We have three options

        int option1 = right + 1;
        int option2 = left+1 + (n-right);
        int option3 = n-left;

        return Math.min(option1 , Math.min(option2, option3));
    }
}