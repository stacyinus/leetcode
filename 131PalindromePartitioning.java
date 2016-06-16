/*
131. Palindrome Partitioning 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

/*
    DFS: O(n2)
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0 )   
            return result; 
        for(int k = 0; k < s.length(); k ++){
            if(isPalindrome(s, 0, k)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(s.substring(0,k+1));
                List<List<String>> tmpList = partition(s.substring(k+1));
                if(tmpList.size() == 0)
                    result.add(list);
                for(List<String> r : tmpList){
                    r.addAll(0,list);
                    result.add(r);
                }    
            }
        }
        return result;        
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}