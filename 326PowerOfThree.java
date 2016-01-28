/*
326. Power of Three

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class 326PowerOfThree {
    //iterative
    public boolean isPowerOfThree(int n) {
    	if(n<=0)
    		return false;
        while(n%3==0)
        	n/=3;
        return n==1;
    }
    //recursive
    public boolean isPowerOfThree(int n) {
    	if(n<=0)
    		return false;
        if(n==1)
        	return true;
        if(n%3==0)
        	return isPowerOfThree(n/3);
        return false;
    }
    //no loop.
    public boolean isPowerOfThree(int n) {
        return n<=0?false:n==Math.pow(3,Math.round(Math.log(n)/Math.log(3)));
    }
	public boolean isPowerOfThree(int n) {
        return n<=0?false:(Math.log10(n)/Math.log10(3))%1==0;
    }    
}