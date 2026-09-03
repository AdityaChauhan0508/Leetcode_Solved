class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while(n > 0) {

            count += n % 2; //Step 1 - check
            n = n >> 1;  //Step 2 - We replaced division with a right shift.
        }
        return count;
    }
}