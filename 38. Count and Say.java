/*
38. Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
// second round
public class Solution {
    public String countAndSay(int n) {
        String r = "1";
        while (n > 1) {
            char[] a = r.toCharArray();
            char cur = a[0];
            char count = '1';
            StringBuilder sb = new StringBuilder();
            for (int i = 1 ; i < a.length; i ++) {
                if (a[i] == cur) count ++;
                else {
                    sb.append(count).append(cur);
                    cur = a[i];
                    count = '1';
                }
            }
            sb.append(count).append(cur);
            r = sb.toString();
            n--;
        }
        return r;
    }
}
// first round
public class Solution {
	//recursive
    public String countAndSay(int n) {
    	if(n==1) return "1";
        String last = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c = last.charAt(i);
        int count =0;
        while(i<last.length()){
        	if(c==last.charAt(i)){
        		count++;
        		i++;
        	}
        	else{
        		sb.append(Integer.toString(count));
        		sb.append(c);
        		c = last.charAt(i);
        		count = 0;
        	}
        }
        sb.append(Integer.toString(count));
        sb.append(c);
        return sb.toString();
    }
}