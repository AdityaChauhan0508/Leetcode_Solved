class Solution {
    public int missingNumber(int[] nums) { 
        
    //xor
    //XOR(all expected numbers)
    //         ^
    //XOR(all array numbers)
    //         ↓
    //missing number

    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;   //XOR(all expected numbers)
        res ^= nums[i];     //XOR(all array numbers)
    }
    return res;
    }
}