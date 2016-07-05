/*
	371. Sum of Two Integers
	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

	Example:
	Given a = 1 and b = 2, return 3.
*/

/*
	bitwise. 
*/
public class Solution {
	// freaking concise solution.
    public int getSum(int a, int b) {
        if((a & b )== 0){	// a和b的对应位一定不都为1。（可为10， 01， 00），因此不存在进位的情况， 可直接return a|b
            return a|b;
        }
        return getSum(a^b, (a&b) <<1); // a^b取出ab不同的位，a&b取出ab相同且都为1的位，他们相加会进位导致前一位变成1， 所以a&b << 1 表示相加后的结果。
    }
    // my solution using carry.
    public int getSum(int a, int b) {
        boolean carry = false;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            int tmp = 0;
            if (carry) {
                if ( (x^y) == 1) {
                    tmp = 0;
                }    
                else if (x == 0) {
                    carry = false;
                    tmp = 1;
                }
                else tmp = 1;
            }
            else {
               tmp = (x^y);
               if (tmp == 0 && x == 1) carry = true;
            }
            result += (tmp << i);
        }
        return result;
    }
}