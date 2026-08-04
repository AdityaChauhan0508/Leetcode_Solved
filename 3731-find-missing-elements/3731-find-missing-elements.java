class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Set<Integer> numSet = new HashSet<>();
        int minVal = nums[0];
        int maxVal = nums[0];

        for(int num : nums){
            numSet.add(num);
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        List<Integer> missing = new ArrayList<>();
        for(int i=minVal; i<= maxVal; i++){
            if(numSet.contains(i)) {
                continue;
            }else{
                missing.add(i);
            }
        }
        return missing;
    }
}