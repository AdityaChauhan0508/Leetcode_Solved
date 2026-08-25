class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int cur = k;

        while(set.contains(cur)) {
            cur += k;
        }
        return cur;
    }
}