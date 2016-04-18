/*
50. Pow(x, n) 

Implement pow(x, n).
*/

public class Solution {
	// recursive
    public double myPow(double x, int n) {
        if(x==0)
        	return 0;
        if(n==0)
        	return 1;
        double a = Math.abs(n);//dont have to cast to long, because the abs of min int is itself.
        double tmp = mypow(x,a/2);
        double result = tmp*tmp;
        if(a%2!=0)
        	result *= x;
        return n>0?result:1/result;
    }
    // iterative
    public double myPow(double x, int n) {
    	long a = Math.abs((long)n);
    	double result = 1;
    	double tmp = x;
    	while(a>0){
    		if((a&1) == 1)
    			result *= tmp; 
    		tmp*=tmp;
    		a>>=1;
    	}
    	return n>0?result:1/result;
    }

}