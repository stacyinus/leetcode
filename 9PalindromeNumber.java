/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Subscribe to see which companies asked this question*/
/*
    Method 1:convert to string and check parlindrome. no overflow issue.
    Method 2:revert the number and see if equals to orignal num. need to consider overflow.
    
    Do we need to think about overflow?
    For method 1, no , because it's comparing char in string.
    For method 2, acutally no either, because we pass in an int, if after reverting, it overflowed, 
    the reverted number will never be origin number.
    note : 
    Integer.MAX_VALUE + 1 == Integer.MIN_VALUE  
    Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
*/

public class 9PalindromeNumber {
    // this method we dont need to consider overflow 
     public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
     }    

    //revert the number and see if it equals to the original number
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int revert = 0;
        int origin = x;
        while ( x > 0) {
            revert = revert * 10 + x % 10;
            x = x / 10;
        }
        return revert == origin;
    }      
}