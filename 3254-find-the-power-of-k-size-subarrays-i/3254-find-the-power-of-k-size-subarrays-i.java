class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int ans[] = new int[n-k+1];

        int i=0, j=0, index=0;

        while(j < n) {

            if(j > 0 && nums[j] != nums[j-1]+1) {
                i = j;
            }

            if(j - i + 1 >= k) {
                ans[index++] = nums[j];
                i++;
            } else if(j >= k - 1) {
                ans[index++] = -1;
            }
            j++;
        }     
        return ans;   
    }
}