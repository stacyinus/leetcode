/*
58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

*/

public class 58LengthOfLastWord {
	//use java string functions (3ms)
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0)
        	return 0;
        String[] ss = s.trim().split(" ");
        if(ss.length==0)
        	return 0;
        return ss[ss.length-1].length();
    }
    //directly check the char in s.(0ms)
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0)
        	return 0;
        int l = 0;
        boolean b = false;
        for(int i=s.length()-1;i>=0;i--){
        	char c = s.charAt(i);
        	if(c==' '){
        		if(!b)
 	       			continue;
 	       		break;
        	}
 	       	else{
 	       		b=true;
 	       		l++;
 	       	}
        }
        return l;
    }   
}