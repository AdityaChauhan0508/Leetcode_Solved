class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while(n > 0) {

            count += n % 2; //Step 1 - check
            n /= 2;  //Step 2 - Discard
        }
        return count;
    }
}