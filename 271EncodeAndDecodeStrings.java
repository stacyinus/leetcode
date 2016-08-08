/*
Leetcode: Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.
Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. 
Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

*/

// http://buttercola.blogspot.com/2015/09/leetcode-encode-and-decode-strings.html
/*
  12bac,#121,abc => "5#12ba14##121
*/
public class Codec {
 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      if (strs == null || strs.size(0) == 0) return "";   
      StringBuilder sb = new StringBuilder();
      for (int i = 0 ; i < strs.length; i ++) {
        if (strs[i] == null || strs[i].length() == 0) sb.append("0#");
        else sb.append(strs[i].length()).append("#").append(strs[i]);
      }
      return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> result = new ArrayList<String>();
      if (s.length() == 0) return result;
      int i = 0;
      while (i < s.length()) {
        //find the first # from i
        int starti = i;
        while (i < s.length() && s.charAt(i) != '#') {
          i++;
        }
        int l = Integer.parsInt(s.substring(starti, i++));
        String str = "";
        if(l > 0) {
          str = s.substring(i, i + l);
        }
        result.add(str);
        i = i + l;
      }
      return result;
    }
}