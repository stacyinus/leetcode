/*
28. Implement strStr()
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class 28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++){
        	if(haystack.substring(i,i+needle.length()).equals(needle))
        		return i;
        }
        return -1;
    }
	//KMP?
    public int strStr2(String haystack, String needle) {
    }
}