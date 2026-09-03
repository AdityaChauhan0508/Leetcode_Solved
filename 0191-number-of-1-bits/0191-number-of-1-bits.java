class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while(n > 0) { //T.C = O(log n) or 0(32) , S.C = 0(1)

        //The n & 1 operation zeroes out everything except the final digit.
        //If the final digit is 1, the result is 1. If 0, the result is 0.

            if((n & 1) != 0) { //Native bit check
                count++;
            }
            n = n>>1;  //Native bit drop
        }
        return count;
    }
}