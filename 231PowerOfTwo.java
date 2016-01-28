/*
231. Power of Two
Given an integer, write a function to determine if it is a power of two.
*/

public class 231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
        	return false;
        return n==(Math.pow(2,Math.round(Math.log(n)/Math.log(2))));
    }
}