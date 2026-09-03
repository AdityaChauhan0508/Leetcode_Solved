class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
       
        for(int x : nums1) {
            if (x % 2 == 1) 
                return nums1[0] % 2 == 1;
        }
        
        
        return true;
    }
}