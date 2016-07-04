/*
43. Multiply Strings 
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.

*/
/*
	eg. 238 * 24 = 5712

				2	3	8
			* 		2	4
			---------------
				8	12	32
			4	6	16
			---------------
			5	7	1	2
		1. num1 与 num2 相乘结果的长度最长为num1.length + num2.length
		2. 错位相乘，将结果store在相应的位置上。
		3. 处理进位。
		4. 形成string，注意开始为0的情况。 
*/
public class Solution {
    public String multiply(String num1, String num2) {
    	char[] a1 = num1.toCharArray();
    	char[] a2 = num2.toCharArray();
    	int l1 = num1.length(), l2 = num2.length();
    	int[] p = new int[l1+l2];
    	for (int i = l1 - 1; i >= 0; i--) {
    		for (int j = l2 -1 ; j >= 0; j--) {
    			p[l1 + l2  - 2 - i - j] += (a1[i] - '0') * (a2[j] - '0'); 
    		}
    	}
    	//System.out.println(Arrays.toString(p));
    	for (int i = 0; i < p.length - 1; i++) {
    		if (p[i] >= 10) {
        		p[i + 1] += p[i] / 10;
        		p[i] = p[i] % 10;     		    
    		}
    	}
    	//System.out.println(Arrays.toString(p));
    	StringBuilder sb = new StringBuilder();
    	boolean found = false;
    	for (int i = p.length - 1; i >=0 ; i--) {
    		if (p[i] > 0 || found) {
    		    found = true;
    			sb.append(Integer.toString(p[i]));
    		}
    	}
    	return sb.length() == 0 ? "0" : sb.toString();
    }
}