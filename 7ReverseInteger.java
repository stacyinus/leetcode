/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class 7ReverseInteger {
    public int reverse1(int x) {
        long result = 0;
        while(x!=0){
            result = 10*result + (x%10);
            x=x/10;          
        }
        return((result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)?0:(int)result);
    }
    
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