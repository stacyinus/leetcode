/*
172. Factorial Trailing Zeroes 

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class 172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
    	int sum = 0;
    	while(n/5>0){
    		sum+=n/5;
    		n=n/5;
    	}
    	return sum;
    }
}