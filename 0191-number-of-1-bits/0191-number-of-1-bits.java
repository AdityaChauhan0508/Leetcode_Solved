class Solution {
    public int hammingWeight(int n) {
        //Brian Kernighan's Algorithm (O(k) time complexity).

        int count = 0;

        while(n > 0) {

            n = n & (n-1);
            count++;
        }
        return count;
    }
}