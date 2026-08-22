class Solution {
    public boolean checkDivisibility(int n) {

        int num = n;
        
        int sum = 0, product = 1;
        int totalSum = 0;
        while(num > 0) {

            int digit = num % 10;

            sum += digit;
            product *= digit;

            num /= 10;
        }

        totalSum = sum + product;

        if(n % totalSum == 0) {
            return true;
        }
        return false;
    }
}