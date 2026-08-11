class Solution {
    public int missingInteger(int[] nums) {

        int seqSum = nums[0];

        HashSet<Integer> set = new HashSet<>();

        // Store all elements
        for (int num : nums) {
            set.add(num);
        }
        //sum of the longest sequential prefix
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                seqSum += nums[i];
            } else {
                break;
            }
        }
        //the smallest missing integer >= seqSum
        while (set.contains(seqSum)) {
            seqSum++;
        }
        return seqSum;
    }
}