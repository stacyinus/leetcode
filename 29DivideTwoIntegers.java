/*
29. Divide Two Integers 
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

*/
//http://blog.csdn.net/zmazon/article/details/8262185
public class Solution {
    public int divide(int dividend, int divisor) {
    	if(divisor == 0)
    		return Integer.MAX_VALUE;
		long divd = Math.abs((long)dividend);//Here you have to cast dividend to long before getting the abs value
		long divr = Math.abs((long)divisor);
		long result = 0;// Here you need to use long instead of int to avoid overflow
		while(divd>=divr){
			for(long tmp = divr, count=1;divd>=tmp;count>>=1, tmp>>=1){
				divd -= tmp;
				result += count;
			}
    	}
    	result = ((dividend > 0) & (divisor > 0))? result: -result;
    	//Here you have to check overflow.
    	if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
    		return Integer.MAX_VALUE;
    	return (int)result;
	}
}