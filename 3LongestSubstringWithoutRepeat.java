/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/


public class 3LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring2(String s) {
        if(s==null||s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        char[] chars = s.toCharArray();
        int maxLen = 1;
        for(int i =0; i<s.length()-maxLen;i++){
            HashSet<Character> set = new HashSet<Character>();
            int j = i;
            for(;j<s.length();j++){
                if(containDuplicatedChar(set,chars[j])){
                    if(maxLen <j-i)
                        maxLen = j-i;
                    break;
                }
            }
            if(j==s.length())
                return j-i;
        }
        return maxLen;
    }
    private boolean containDuplicatedChar(HashSet<Character> set, Character c){
        if(!set.contains(c)){
            set.add(c);
            return false;
        }   
        else
            return true;
    }
    
    public int lengthOfLongestSubstring(String s) {
        int start = 0,max =0,tempMax=0;
        if(s==null||s.length()==0)
            return max;
        if(s.length()==1)
            return 1;
        HashMap<Character,Integer> charCounter = new HashMap<Character,Integer>();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(charCounter.containsKey(c)&&charCounter.get(c)>=start){
                max = Math.max(max,tempMax);
                start = charCounter.get(c)+1;
                tempMax = i-start;
            }
            tempMax++;
            charCounter.put(c,i);
        }
        return Math.max(max,tempMax);
    }
}