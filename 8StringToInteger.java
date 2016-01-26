/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.
*/


public class 8StringToInteger {
    public int myAtoi(String str) {
 		long result = 0;
 		int neg = 1;
 		boolean flag1 = false;
 		boolean flag2 = false;
 		for(int i = 0;i<str.length();i++){
 			if(!flag1&&!flag2&&result ==0){
 				if(str.charAt(i)==' ')
 					continue;
 				else if(!flag1 &&(str.charAt(i)=='-'||str.charAt(i)=='+')){
 				    neg = str.charAt(i)=='-'?-1:1;
 				    flag1 = true;
 				}
 				else if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
 					result = neg*(str.charAt(i)-'0');
 					flag2 = true;
 				}
 				else
 					return 0;
 			}
 			else{
 				if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
 				    result = neg*(10*result + (int)(str.charAt(i)-'0'));
 				    if(result>Integer.MAX_VALUE)
 				    	return Integer.MAX_VALUE;
 				    if(result<Integer.MIN_VALUE)
 				    	return Integer.MIN_VALUE;	
 				}
 				else
 					break;
 			}
 		}
 		return result;
    }
}