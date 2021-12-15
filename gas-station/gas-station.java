class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int leastGas = Integer.MAX_VALUE;
        int leastGasIndex = 0;
        int curGas = 0;
        for (int i = 0 ; i < gas.length; i++) {
            sumGas += gas[i];
            int costToArrive = (i == 0) ? cost[gas.length - 1] : cost[i-1];
            sumCost += costToArrive;
            
            curGas =  curGas + gas[i] - cost[i];
            System.out.println("at: " + i + " : " + curGas);
            if (curGas < leastGas) {
                leastGas = curGas;
                leastGasIndex = i;
            }
        }
        
        if (sumGas < sumCost) return -1;
        return (gas.length + leastGasIndex + 1) % gas.length;
    }
}