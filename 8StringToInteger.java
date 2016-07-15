/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.
*/
/*
	think about test case first:
	input with space
	123
	-123
	+123
	123.1 -- 123
	123 b -- 123
	b 123 -- 0 
	XE#@#$
	overflow --> Integer.MAX/MIN
	long can also overflow!!!!!!

*/

public class 8StringToInteger {

	/*
		use auto machine.
	*/
    public int myAtoi(String str) {
        str = str.trim();
        int[][] autoMachine = new int[][]{{1,2},{-1,2},{-1,2}};
        int state = 0;
        long result = 0;
        boolean neg = false;
        for (int i = 0; i < str.length(); i++) {
        	int tran = getTransition(str.charAt(i));
        	if (tran == -1) break;
        	state = autoMachine[state][tran];
        	if (state == -1) break;
        	if (state == 1 && str.charAt(i) == '-') {
        		neg = true;
        	}
        	if (state == 2) {
        	    if (neg)
        	        result = result * 10 - (str.charAt(i) - '0');
        	    else
            	    result = result * 10 + (str.charAt(i) - '0');
        	}
        	if ( !neg && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        	if ( neg && result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)result;
    }
    private int getTransition(char c) {
    	if (c == '+' || c == '-') return 0;
    	if (c >= '0' && c <= '9') return 1;
    	return -1;
    }
    /*
		理清思路再写很简单
    */
    public int myAtoi(String str) {
        str = str.trim();
        long result = 0;
        boolean neg = false;
        for (int i = 0; i < str.length(); i ++ ) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                neg = str.charAt(i) == '-' ? true : false;
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            result = neg ? result * 10 - ( str.charAt(i) - '0' ) : result * 10 + ( str.charAt(i) - '0' );
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}