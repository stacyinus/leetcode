/*
241. Different Ways to Add Parentheses

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
    	List<Integer> result = new ArrayList<Integer>();
    	boolean find = false;
        for(int i=0;i<input.length();i++){
        	char c = input.charAt(i);
        	if(c=='+'||c=='-'||c=='*'){
        		find = true;
        		List<Integer> left = diffWaysToCompute(input.substring(0,i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
        		for(Integer a:left){
        			for(Integer b:right){
        				if(c=='+') result.add(a+b);
        				else if(c=='-') result.add(a-b);
        				else if(c=='*') result.add(a*b);
        			}
        		}
        	}	
        }
        if(!find)
        	result.add(Integer.parseInt(input));
        return result;
    }
}