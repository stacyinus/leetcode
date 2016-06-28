/*
93. Restore IP Addresses 

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


*/
/*
    DFS, Backtracking : there are 4 parts in the IP address, and each part is smaller than 255.
                        special case to handle 0: eg: 10100 could be 1.0.10.0 / 10.1.0.0 couldn't be
                        1.01.0.0. So if 0 is start of one part, no need to permutate that part.

    25525511135
    2.   5. 55. 552
    25.  52
    255.  2
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>(); 
        if(s == null || s.length() == 0 || s.length() > 12){
            return result;
        }
        backTracking(result, s, "", 0);
        return result;
    }
    private void backTracking(List<String> result, String s, String tmp, int count) {
        if (count == 4 && s.length() == 0) {
            result.add(tmp.substring(0,tmp.length() - 1));
            return;
        }
        for (int i = 0; i < 3 && i < s.length(); i++) {
            if (i > 0 && s.charAt(0) == '0')    // this is the special case to handle 0s.
                break;
            String  cur = s.substring(0, i + 1);
            if (Integer.valueOf(cur) <= 255) {
                backTracking(result, s.substring(i + 1), tmp + cur + ".", count+1);
            }
        }
    }
}