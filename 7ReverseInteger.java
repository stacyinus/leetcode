/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
/*
    Be careful of overflow!!!!!!!!!! Remember to convert x to long first. 
    think about several cases: intput MAX_VALUE, input is MIN_VALUE, overflow after reverse.
    negetive input: we don't really need to specially consider negtive case here, eg. x = -123
    x % 10 = -3, x / 10 = - 12
    after frist loop , result = -3, x = -12
    after second loop, result = -32, x = -1
    after third loop result = -321, x = 0.
*/
public class 7ReverseInteger {
    // t
    public int reverse1(int x) {
        long result = 0;
        while(x!=0){ //eg. x - -123, result 
            result = 10*result + (x%10); 
            x=x/10;          
        }
        return((result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)?0:(int)result);
    }
    //this alternative method doesn't need to convert because you check before it can overflow.
    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10)
                return 0;
            result = 10*result + (x%10);
            x=x/10;          
        }
        return result;
    }    
}