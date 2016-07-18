/*
84. Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/
/*
	3 different ways:
	1. O(n2) : for each point, calculate the largest area from this point to the end .
	2. O(nlogn): 
	3. O(n): http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
        	return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
        	int cur = i == heights.length ? -1 : heights[i];
        	while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
        		int h = heights[stack.pop()];
        		int w = stack.isEmpty()? i : i - stack.peek() - 1;
        		max = max > h*w? max: h*w;
        	}
        	stack.push(i);
        }
        return max;
    }
}