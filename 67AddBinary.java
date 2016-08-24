/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

// secound round
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int i1 = a.length() - 1 , i2 = b.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0) {
            char cur = i1 >= 0 ? a.charAt(i1--) : '0';
            cur = i2 >= 0 ? (char) (cur + (b.charAt(i2--) - '0')) : cur;
            if (carry) {
                cur ++;
                carry = false;
            } 
            if (cur > '1') {//0 1 2 3
                cur = (char) (cur - 2);
                carry = true;
            }
            sb.append(cur);
        }
        if (carry) sb.append('1');
        return sb.reverse().toString();
    }
}

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