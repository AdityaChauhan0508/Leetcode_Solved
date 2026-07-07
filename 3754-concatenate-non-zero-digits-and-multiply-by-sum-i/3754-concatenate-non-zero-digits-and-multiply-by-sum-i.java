class Solution {
    public long sumAndMultiply(int n) {

        String str = String.valueOf(n);
        long x = 0;
        
        for(char ch : str.toCharArray()) {
            if(ch != '0'){
                x = x * 10 + (ch - '0');
            }
        }

        long temp = x;
        long sum = 0;

        while(temp > 0) {
            sum += temp % 10;
            temp = temp/10;
        }

        return x * sum;
    }
}