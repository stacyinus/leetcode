/*

10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

*/

/*
//Copy right: Yuran, slightly changed by me.
从整理思路开始
//主要问题是p的下一位是不是*的问题
    1）如果不是：就match当前点，match了，p和s都下移
    2）如果是：那么需要开始尝试移动s的指针然后和p匹配，当前点的match为p='.'，或者p==s，那么就进入下一个递归，或者s++
//边界条件单独处理，当p下一位不是*，如果s结束了，那么返回false; 如果p下一位是'*'，那么如果s结束了，就直接p+2

*/

public class Solution {
        public boolean isMatch(String s, String p) {
            // Note: The Solution object is instantiated only once and is reused by each test case.
            char[] str = s.toCharArray();
            char[] ptr = p.toCharArray();
            return rematch(str, 0, ptr, 0);
        }
        public boolean rematch(char[] str, int s, char[] ptr, int p){
            int slen = str.length;
            int plen = ptr.length;
            if(p == plen) return s == slen;//如果p已经结束但是s还没有结束，肯定不match
            if(p == plen-1 || ptr[p+1] != '*'){
                if( s == slen) return false;//如果p不是带*的，而s结束了，肯定不match
                if( ptr[p] == '.' || ptr[p] == str[s] ) 
                	return rematch(str, s+1, ptr, p+1);
                return false;
            }else{
                while(s <slen && (ptr[p] == '.' || ptr[p] == str[s])){ 
                    if(rematch(str,s,ptr, p+2)) return true;
                    s++;
                }
                return rematch(str, s, ptr, p+2);
            }
        }        
}

/*
    第二遍思路还是不清晰。。。。。。
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
aa, a    --> false
aa, aa   --> true
aa, aa*  --> true
aaa, a*  --> true
abbaab, .* --> true
abb, .*b --> true
aba, .*b --> false
ab,* -->false  anything start with * is false.
aab,c*a*b -->true
aaa,ab*a -->false
a,ab* --> true
"",".*" --true
"","c*c*" -- > true

input could only be three types  '.', '*', and other chars (we use abc to represent)

keep pointer i, j for one string each,  before i,j is matched, after i,j is to be match
1) when next of j is not *, then just compare i with current. if not match, return false, otherwise move to next.
2) when next of j is *, then if j is abc, just com

*/
public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null && p == null || s.length() == 0 && p.length() == 0) return true;
            if (s == null || p == null || p.length() == 0 || p.charAt(0) == '*') return false;
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()) {
                if (p.charAt(j) == '*') return false; 
                if ((j < p.length() - 1 && p.charAt(j + 1) != '*') || j == p.length() - 1){
                    if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') return false;
                    i++;
                    j++;
                }
                else {
                    if (isMatch(s.substring(i), p.substring(j + 2))) return true;
                    if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') return false;
                    int k = i + 1;
                    for (; k < s.length() && (s.charAt(k) == s.charAt(i) || p.charAt(j) == '.'); k ++) {
                        if (isMatch(s.substring(k), p.substring(j + 2))) return true;
                    }
                    i = k;
                    j = j + 2;
                }
            }
            if (i < s.length()) return false;
            
            return isMatch("", );
        }

}
