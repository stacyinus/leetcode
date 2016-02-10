/*
223. Rectangle Area 

Find the total area covered by two rectilinear rectangles in a 2D plane.

Imag:
https://leetcode.com/static/images/problemset/rectangle_area.png

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class 223RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	        
    		int area1 = (C-A)*(D-B);
    		int area2 = (G-E)*(H-F);
    		//if no overlap
	        if(C<=E||G<=A||D<=F||H<=B) 
	        	return area1+area2;
	        //if there's overlap
	        int l = Math.max(A,E);
	        int r = Math.min(C,G);
	        
	        int b = Math.max(B,F);
	        int u = Math.min(D,H);
	        return area1+area2-(r-l)*(u-b);           
    }
}