class Solution {
    public int minMoves(int[] nums) {

        // Why This Works T.C = O(n) S.C = O(1)
        // Every operation increases all elements except one.
        // This is equivalent to decreasing exactly one element relative to the others.
        // To make all elements equal, every element larger than the minimum must eventually be reduced to the minimum.
        // An element nums[i] requires exactly nums[i] - minimum reductions.
        // Summing these required reductions gives the minimum number of moves.
        // Thus, the algorithm computes exactly the number of operations needed.
        
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            min = Math.min(num, min);
        }

        int moves = 0;

        for(int num : nums) {
            moves += num - min;
        }
        return moves;

    }
}