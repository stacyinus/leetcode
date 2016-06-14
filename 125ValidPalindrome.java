/*
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
/*
    easy two pointers: start from 0 and length - 1.
*/

public class 125ValidPalindrome {
    public boolean isPalindrome(String s) {
 		int i=0;
 		int j=s.length()-1;
 		while(i<j){
 			char l = toLowerCase(s.charAt(i));
 			char r = toLowerCase(s.charAt(j));
 			if(!validChar(l)){
 				i++;
 				continue; 				
 			}
			if(!validChar(r)){
				j--;
				continue;
			}
  			if(l!=r)
 				return false;
 			i++;
 			j--;
 		}       
 		return true;
    }
    private char toLowerCase(char c){
    	if(c<='Z'&&c>='A')
    		return (char)(c+('a'-'A'));
    	return c;
    }
    private boolean validChar(char c){
    	return ((c<='Z'&&c>='A')||(c<='z'&&c>='a')||(c<='0'&&c>='9'));
    }
}