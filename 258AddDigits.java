/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

public class Solution {
	//recursive
    public int addDigits1(int num) {
        int sum = 0;
        while(num>0){
            sum += num%10;
            num = num/10;
        }
        if(sum>=10)
            return addDigits(sum);
        return sum;
    }
    //iterative
    public int addDigits(int num) {
    	int sum = 0;
    	while(num>0){
    		sum += num%10;
    		 num /= 10;
    		if(num==0 && sum/10>0){
    			num = sum;
    			sum = 0;
    		}
    	}
    	return sum;
    }    
}