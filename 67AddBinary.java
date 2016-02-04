/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class 67AddBinary {
	//iterative
    public String addBinary(String a, String b) {
        boolean carry = false;
        char[] array = new char[Math.max(a.length(),b.length())];
        int i = 0;
        while(i<a.length()||i<b.length()){
        	char tmp='0';
        	char c1='0';
        	char c2 ='0';
        	if(carry){
        		tmp = '1';
        		carry = false;
        	}
        	if(i<a.length())
	        	c1 = a.charAt(a.length()-i-1);
    		if(i<b.length())
        		c2 = b.charAt(b.length()-i-1);
        	tmp += (c1-'0')+(c2-'0');
        	if(tmp>'1'){
        		carry =true;
        		tmp -=2;
        	}
        	array[array.length-i-1]=tmp;
        	i++;
        }
        StringBuilder sb = new StringBuilder();
        if(carry) 
        	sb.append('1');
        return sb.append(array).toString();  
    }
}