/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class 171ExcelSheetColumnNumber {
    //iterative
    public int titleToNumber(String s) {
        int sum = 0;
        int length = s.length();
	    for(int i = 0; i<length;i++){
            char c = s.charAt(i);
            if(c<'A'||c>'Z')
                return -1;
            sum += Math.pow(26,length-1-i)*(s.charAt(i)-'A'+1);
	    }    
        return sum;
    }    
    //recursive
    public int titleToNumber(String s) {
    	if(s==null)
    		return 0;
    	int sum = 0;
    	for(int i = 0 ; i<s.length(); i++){
    		char c = s.charAt(i);
    		if(c<'A'||c>'Z')
                return -1;
    		sum = sum * 26 + (c-'A'+1);
    	}
    	return sum;
    }   
    public int titleToNumber(String s) {
    	if(s==null||s.length()==0)
    		return 0;
    	if(s.length()==1){
    		if(s.charAt(0)<'A'||s.charAt(0)>'Z')
                return 0;
    		return s.charAt(0)-'A'+1;
    	}	
    	int sum = 0;
    	sum =  26*titleToNumber(s.substring(0,s.length()-1))+(s.charAt(s.length()-1)-'A'+1);
    	return sum;
    }       
}