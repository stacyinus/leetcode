/*
191. Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

public class 191Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i = 0;
        int count = 0;
        while(i<32){
        	if(((n>>i)&1)==1)
        		count ++;
        	i++;
        }
        return count;
    }
}