class Solution {
    public int canCompleteCircuit(int[] gasArr, int[] cost) {

        int totalGas = 0 , gas = 0, start = 0;

        for(int i=0; i<gasArr.length; i++) {

            int diff = gasArr[i] - cost[i];

            totalGas += diff;
            gas += diff;

            if(gas < 0) {
                start = i+1;
                gas = 0;
            }
        }
        if(totalGas < 0 ) {
            return -1;
        }
        
        return start;
    }
}