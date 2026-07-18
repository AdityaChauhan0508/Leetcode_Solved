class Solution {

    public static int gcd(int min , int max) {
        if(max == 0) return min;

        return gcd(max, min % max);
    }

    public int findGCD(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return gcd(min, max);
    }
}