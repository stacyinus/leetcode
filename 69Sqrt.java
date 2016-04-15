/*
69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {

/*
	Generic binary search, int mid = lo + (hi - lo) / 2 + 1; gives preference on right value, 
	so this way we are searching for the largest mid value that satisfy the condition, which is what sqrt(x) requires.
*/
	public int mySqrt(int x) {
	    int lo = 1, hi = x;
	    while(lo < hi) {
	        int mid = lo + (hi - lo) / 2 + 1;
	        if(mid > x / mid) {
	            hi = mid - 1;
	        } else {
	            lo = mid;
	        }
	    }
	    return hi;
	}
/*
	use the template of jiuzhang
*/
    public int mySqrt(int x) {
        if(x<1)
        	return x;
        int s = 1, e=x;
        while(s+1<e){
        	int m = s+(e-s)/2;
        	if(m == x/m)
        		return m;
        	else if(m > x/m)
        		e = m;
        	else
        		s = m;
        }
        return s;
    }	
}