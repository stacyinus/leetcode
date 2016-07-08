/*
233. Number of Digit One
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/
/*  eg. 574 -- < 100   n1 = 9 + 9 + 1*2 = 20 
            --  >=100 < 200 (first digit is 1) 100 + 20
            --  > 2XX  3XX 4XX   20 *3
            --  500 - 574 = countDigitOne(74) -- < 10  1 
                                              -- >= 10 < 20   11
                                              -- 2X, 3X...6X     5 * 1
                                              -- 7X = countDigitOne(4) 1 

        174 -- < 100   n1 = 9 + 9 + 1*2 = 20 
            -- 100~174  75 + countDigitOne(75) =75 + 18 = 93

    number of digit 1 for all numbers with 1 digit  - 1
    number of digit 1 for all numbers with 2 digit  - 20
    number of digit 1 for all numbers with 3 digit  - 300
    number of digit 1 for all numbers with 4 digit  - 4000
    number of digit 1 for all numbers with n digit  - n* 10^(n-1)
*/
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) 
            return 0; 
        if (n < 10)
            return 1;
        int i = String.valueOf(n).length() - 1;//number of digits - 1, eg. 547,  i = 2
        
        int count = (int) Math.pow(10, i - 1) * i;
        //System.out.println("count = " + count);
        int base = (int)Math.pow(10,i);
        //System.out.println("base = " + base);
        if (n / base == 1)
            return count + (n - base + 1) + countDigitOne(n % base);
        return (n/base * count + base  + countDigitOne(n % base));          
    }
}