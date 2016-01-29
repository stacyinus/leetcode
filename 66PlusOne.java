/*
66. Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class 66PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        for(int i=digits.length-1;i>=0;i--){
        	if(i==digits.length-1||carry){
				digits[i]+=1;
				carry=false;
				if(digits[i]>=10){
					digits[i]-=10;
					carry = true;
				}
			}
			else
				break;
        }
        if(carry){
        	int[] tmp = new int[digits.length+1];
        	tmp[0]=1;
        	for(int i=1;i<tmp.length;i++)
        		tmp[i]=digits[i-1];
        	digits=tmp;
        }
        return digits;
    }
}