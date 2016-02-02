/*
190. Reverse Bits 

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

public class 190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
        	if((n&(1<<i))!=0)//here use <>0 because int is signed, when the front digit is 1, the value is <0
        		result+= (1<<(31-i));
        }		
        return result;  
    }
    // to improve the function, we can keep a cache map to contain the 
  	//byte reverse value
    public int reverseBitsImproved(int n) {
 
    }

}