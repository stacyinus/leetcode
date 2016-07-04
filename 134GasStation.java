/*

134. Gas Station 

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

*/

/*
    Greedy: Tip 1 : if the total of gas[i] - cost[i] is >= 0, then the car can drive a cirlce.
            Tip 2 : at each point, tank should never be < 0. 
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, index = 0, tank = 0;
        for (int i = 0; i < gas.length ; i ++) {
            int tmp = gas[i] - cost[i];
            tank += tmp;
            if(tank < 0) { // if current tank is < 0, that means the start point could only be after i. why?
                            //eg. at index i tank < 0, that means sum[0 ~ i] < 0.
                            // if in the end, total > 0, then sum [i + 1 ~ end of the array] > 0
                tank = 0;
                index = i + 1;
            }
            total += tmp;
        }
        return total >= 0 ? index : -1;
    }
}