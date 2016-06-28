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
