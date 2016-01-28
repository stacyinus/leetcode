/*
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class 70ClimbingStairs {
    public int climbStairs(int n) {
        if(n==0||n==1)
            return 1;
        int i = 1; //n==0
        int j = 1; //n==1
        int result = 0;
        for(int k=2;k<=n;k++){
            result = i+j;
            j = i;
            i = result;
        }
        return result;        
    }
}
