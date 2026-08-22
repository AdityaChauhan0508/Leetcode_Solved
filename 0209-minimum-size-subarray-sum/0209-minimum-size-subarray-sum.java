class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        //Sliding Window Approach

        int start = 0, end = 0, total = Integer.MAX_VALUE, sum = 0;
        int n = nums.length;

        while(end < n) {

            sum += nums[end]; //adding number one by one to sum to reach target

            while(sum >= target) {  //jab target pura ho jaye toh window size decrease krna
                total = Math.min(total, end - start + 1);  // current window size store krna
                sum -= nums[start++];  //sum se remove kiya element minus krna and start++ krna
            }

            end++;  //window length increase krna jab tak target acheive nhi hota
        }
        return total == Integer.MAX_VALUE ? 0 : total; 
    }
}