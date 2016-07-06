/*
65. Valid Number  
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/
/*
	auto machine: this most important part for this questions is think about all possible cases and communicated with the interviewer 
				  whether this is valid. 
				  In this case: heading/trailing spaces are valid, e has to has integer numbers before and after,
				  .1 or 1. is valid, 
				  valid cases: ".1", "1.", "0e1", "+1", "+.1","+1.","1.e1"
				  invalid cases: ".", "e1","1e","e"
*/
public class Solution {
    public boolean isNumber(String s) {
        int[][] auto = new int[][] {{1, 2, -1 ,7, 9}, {1, 3, 4, -1, 10}, {5, -1, -1, -1, -1}, {5, -1, 4, -1, 10}, {6, -1, -1, 8, -1}, 
            {5, -1, 4, -1, 10}, {6, -1, -1, -1, 10}, {1, 2, -1, -1, -1}, {6, -1, -1, -1, -1}, {1, 2, -1, 7, 9}, {-1, -1, -1, -1, 10}};
        int state = 0;
        //s= s.trim(); you can either trim or put " " as an valid input and add state to manage it.
        for (int i = 0; i < s.length(); i++) {
        	int input = convertCharToStateMachineInput(s.charAt(i));
        	if ( input == -1 || auto[state][input] == -1 ){
        		return false;
        	}
        	state = auto[state][input];
        }
        return state == 1 || state == 3 || state == 5 || state == 6 || state == 10; //final state
    }
    private int convertCharToStateMachineInput(char c) {
    	if (c >= '0' && c <= '9') {
    		return 0;
    	}
    	else if (c == '.') {
    		return 1;
    	}
    	else if (c == 'e') {
    		return 2;
    	}
    	else if (c == '+' || c == '-') {
    	    return 3;
    	}
    	else if (c == ' ') {
    	    return 4;
    	}
    	return -1;
    }
}