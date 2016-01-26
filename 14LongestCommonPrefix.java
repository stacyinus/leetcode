/*
Write a function to find the longest common prefix string amongst an array of strings
*/


public class 14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        String temp = strs[0];
        for(int i = 0;i<temp.length();i++){
            int j = 1;
            for(;j<strs.length;j++){
                if(strs[j].length()-1<i)
                    return strs[j];
                if(temp.charAt(i)!=strs[j].charAt(i))
                    break;
            }
            if(j!=strs.length)
                return temp.substring(0,i);
        }
        return temp;
    }     
}