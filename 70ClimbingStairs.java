/*
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
/*
    this is fibinaci, can be optimized to space O(1), and time O(n)
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
    // tail recursion
    public int climbStairs(int n) {
        return help(n, 1 , 0);
    }
    public int help(int term, int val = 1, int prev = 0) {
         if(term == 0) return prev;
         if(term == 1) return val;
         return fib(term - 1, val+prev, val);
    }
}
