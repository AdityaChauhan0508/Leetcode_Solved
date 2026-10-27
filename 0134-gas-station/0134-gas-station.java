class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0 , gasRequired = 0, start = 0;

        for(int i=0; i<gas.length; i++) {

            int diff = gas[i] - cost[i];

            totalGas += diff;
            gasRequired += diff;

            if(gasRequired < 0) {
                start = i+1;
                gasRequired = 0;
            }
        }
        if(totalGas < 0 ) {
            return -1;
        }
        
        return start;
    }
}