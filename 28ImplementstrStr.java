/*
28. Implement strStr()
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
/*
	O(m*n)
*/
public class 28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++){
        	if(haystack.substring(i,i+needle.length()).equals(needle))
        		return i;
        }
        return -1;
    }

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j = 0;
            while(j < target.length()) {
                if(source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}