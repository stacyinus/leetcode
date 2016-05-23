/*
322. Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/


public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] tmp = new int[amount+1];
        Arrays.fill(tmp, -1);
        tmp[0] = 0;
        for(int i = 0; i < coins.length; i++){
        	for(int j = 1; j <=	 amount; j++){
        		if(coins[i] == j)
        			tmp[j] = 1;
        		else if(j>coins[i] && tmp[j-coins[i]] != -1)
        			tmp[j] = (tmp[j-coins[i]] + 1 > tmp[j] && tmp[j] != -1) ? tmp[j] : tmp[j-coins[i]] + 1;
        	}
        }
        return tmp[amount];
    }
}