/*
179. Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/
public class Solution {
    public String largestNumber(int[] nums) {
        
    }
    private boolean compareTo(int a, int b){
    	while(a!=0 && b!=0 && a/10 == b/10){
    		a = a%10;
    		b = b%10;
    	}
    	if(a/10 > b/10)
    		return 1;
    	if(a/10 == b/10)
    		return 0;
    	if(a/10 < b/10)
    		return -1;
    }
}