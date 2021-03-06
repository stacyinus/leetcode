/*
264. Ugly Number II 

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the 
first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. 
Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

*/
public class Solution {
	//better solution
	public int nthUglyNumber(int n) {
		int[] num = new int[n];
		num[0] = 1;
		int i1 = 0,i2 = 0, i3 = 0;
		for(int i = 1; i < n; i++){
			int min = Math.min(Math.min(num[i1]*2, num[i2]*3), num[i3]*5);
			num[i] = min;
			if(min%2 == 0) i1++;
			if(min%3 == 0) i2++;
			if(min%5 == 0) i3++;
		}
		return num[n-1];   
    }
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        LinkedList<Integer> i1 = new LinkedList<Integer>();
        LinkedList<Integer> i2 = new LinkedList<Integer>();
        LinkedList<Integer> i3 = new LinkedList<Integer>();
        for(int i = 1; i < n ; i++){
        	i1.offer(num[i-1]*2);
        	i2.offer(num[i-1]*3);
        	i3.offer(num[i-1]*5);
	        int min = Math.min(Math.min(i1.peek(), i2.peek()), i3.peek());
	        num[i] = min;
	        if(min == i1.peek()) i1.pop();
	        if(min == i2.peek()) i2.pop();
	        if(min == i3.peek()) i3.pop();   	        		
        }
        return num[n-1];
    }


}