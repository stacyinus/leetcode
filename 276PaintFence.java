/*
276.Paint Fence
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
Note:
n and k are non-negative integers.
*/
public class 276PaintFence {
    public int numWays(int n, int k) {
    	if(n==0) return 0;
    	if(n==1) return k;
    	//starting from n=2
    	int diff = k*(k-1);
    	int same = k;
    	for(int i=3;i<=n;i++){
    		//if previous 2 are diff, you can choose diff (k-1) or same from the last color (1).
    		//if previous 2 are same, you can choose only diff, which is (k-1)
    		int temp = diff;
    		diff = temp*(k-1)+ same*(k-1);
    		same = temp; 
    	}
    	return diff+same;
    }
}