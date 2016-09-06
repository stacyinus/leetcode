1. 2Sum: LeetCode
   3SUm: how to use nlogn to solve? leetcode 15

2. Get prime factors

Integer[] decPrime(int n) {  
    List<Integer> list = new ArrayList<Integer>();  
    for (int i=2;i <= n;i++){  
        while(n != i){  
            if(n%i != 0){  
                break;//不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7  
                      //都被除完之后。剩下的因数只能是奇数，且是质数。  
            }  
            list.add(Integer.valueOf(i));  
            n = n/i;  
        }  
    }  
    list.add(Integer.valueOf(n));  
    return list.toArray(new Integer[list.size()]);  
}  

4. leetcode 223. Rectangle Area
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
5. Unique Binary Tree leetcode 96UniqueBinarySearchTrees 97UniqueBinarySearchTreesII

    DP: DP array dp[i] representing the num of unique BSTs from 1 to i. dp[1] = 1
        return dp[n]. 
        dp[i] = num of BSTs with root being 1 + num of BSTs with root being 2 + .... + 
                num of BSTs with root being i
        num of BSTs with root being i = dp[i-1] (left subtree has i - 1 nodes) * dp[n - i] (right subtree has i - 1 nodes)
        hence we know how to get dp[n] using dp[1] -- dp[n-1]
        
        eg: dp[i] = num of unique BSTs given i numbers
            f[i] = num of unique BSTs with i being root
        dp[5] = f[5]    +      f[4]     +   f[3]        +       f[2]    + f[1]
              = dp[4]   + dp[3] * dp[1] + dp[2] * dp[2] + dp[1] * dp[3] + dp[4]

public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int tmp = dp[i-1];
            for (int j = i - 1; j > 1; j--) {
                tmp += dp[j - 1] * dp[i - j];
            }
            tmp += dp[i-1];
            dp[i] = tmp;
        }
        return dp[n];
    } 

public class Solution {
    public List<TreeNode> generateTrees(int n) {   
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    public List<TreeNode> helper(int s, int e) {
        if (s > e) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        if (s == e) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(s));
            return list;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = s; i <= e; i ++)  {
            List<TreeNode> leftNodes = helper(s, i - 1); 
            List<TreeNode> rightNodes = helper(i + 1, e);
            for (TreeNode left: leftNodes) {
                for( TreeNode right : rightNodes ) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }           
        }
        return result;
    }

}

6. String encode/decode: leetcode 271
public class Codec {
 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      if (strs == null || strs.size(0) == 0) return "";   
      StringBuilder sb = new StringBuilder();
      for (int i = 0 ; i < strs.length; i ++) {
        if (strs[i] == null || strs[i].length() == 0) sb.append("0#");
        else sb.append(strs[i].length()).append("#").append(strs[i]);
      }
      return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> result = new ArrayList<String>();
      if (s.length() == 0) return result;
      int i = 0;
      while (i < s.length()) {
        //find the first # from i
        int starti = i;
        while (i < s.length() && s.charAt(i) != '#') {
          i++;
        }
        int l = Integer.parsInt(s.substring(starti, i++));
        String str = "";
        if(l > 0) {
          str = s.substring(i, i + l);
        }
        result.add(str);
        i = i + l;
      }
      return result;
    }
}
7. find min value in a rotated sorted array: 153 leetcode

public class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while ( s + 1 < e) {
            int m = s + ( e - s )/ 2;
            if (nums[m] > nums[e]) {
                s = m;  
            }
            else if (nums[m] < nums[s]) {
                e = m;
            }
            else {
                return nums[s];
            }
        }
        return nums[s] < nums[e] ? nums[s] : nums[e];
    }
}

8. implement a Fibonacci iterator ???

9. 解释输入amazon.com按下回车后发生的一系列事
	client side: 
	1) send address to nearest DNS
	2) return ip address
	3) send http get request to that server
	4) return web content
	web server side:
	1) 收到请求,将请求递交给正在 80 端口监听的HTTP Server( 比较常用的 HTTP Server 有 Apache, Unicorn, Gunicorn, Uwsgi )
	2) HTTP Server 将请求转发给 Web Application (最火的三大Web Application Framework: Django, Ruby on Rails, NodeJS )
	3) Web Application 处理请求 ( a. 根据当前路径 “/”找到对应的逻辑处理模块; b. 根据用户请求参数(GET+POST)决定如何获取/存放数据;
								 c. 从数据存储服务(数据库或者文件系统)中读取数据; d.组织数据成一张 html 网页作为返回结果 )

	4) 浏览器得到结果,展示给用户

10. shift array (shifts an array by N number of steps. E.g. [0,1,2,3,4] shiftArray(arr, 3) -> [2,3,4,0,1]) 
	leetcode189

11. search in rotated array ： leetcode 33

12. valid BST. leetcode 98
    // iterative, use extra space 
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                TreeNode tmp = stack.pop();
                if (pre != null && pre.val >= tmp.val ) {
                    return false;
                }
                pre = tmp;
                root = tmp.right;
            }
            else {
                stack.push(root);
                root = root.left;   
            }
        }
        return true;
    } 
13. fib, 非要让我不用 temp 和不能多用两个数…… 
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

14. edit distance，本来想背dp答案的，结果没等我开口给我简化了并让我用 recursion 写 ： leetcode 72

15. 给两个sorted array求出第k个最小值： leetcode 4 变形
    private int findKthNumber(int k, int[] nums1, int i, int[] nums2, int j) {//k is index
        if (nums1.length - i > nums2.length - j)
            return findKthNumber(k, nums2, j, nums1, i);
        if ( i >= nums1.length ) return nums2[j + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int k1 = Math.min(nums1.length - i, k/2);
        int k2 = k - k1;
        if (nums1[i + k1 - 1] >= nums2[j + k2 - 1]) {
            return findKthNumber(k - k2, nums1, i, nums2, j + k2);
        }
        return findKthNumber(k - k1, nums1, i + k1, nums2, j);
    }
16. LRU CACHE leetcode 146

17.给一个数组 判断是否有三个数 可组成三角形

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int s[]) {
        // write your code here
        Arrays.sort(s);
        int k = 2, count = 0;
        while(k < s.length){
            int left = 0, right = k - 1;
            while(left < right){
                if(s[left] + s[right] > s[k]){
                    count += right - left;
                    right--;
                }
                else{
                    left++;
                }
            }
            k++;
        }
        return count;
    }
}
18. caculator: leetcode 224 and 227






public class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> signs = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int num = c - '0';
                while( i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' ){
                    num = 10 * num + s.charAt(i+1) - '0';
                    i++;
                }
                if(!signs.isEmpty() && (signs.peek() == '*' || signs.peek() == '/')){
                    char sign = signs.pop();
                    nums.push(sign == '*' ? nums.pop() *  num : nums.pop() /  num);
                }
                else
                    nums.push(num);
            }
            else if( c == '*' || c == '/'|| c == '+' || c == '-' ){
                if(!signs.isEmpty() && ( c == '+' || c == '-') ){
                    int num = nums.pop();
                    char sign = signs.pop();
                    nums.push(sign == '+' ? nums.pop() +  num : nums.pop() -  num);
                }
                signs.push(c);
            }
        }
        int result = nums.pop();
        return signs.isEmpty()? result : (signs.pop() == '+' ? nums.pop() +  result : nums.pop() -  result);
    }
}

Behavior :
Team structure, what does every team do, I picked his team, which does tools and release stuff.
Web:
1.      What happens when entering www.google.com 
(send get request, DNS, load balancer, server, find static file or go into MVC and database interactions, send back result)
2.      Scalability. Now we have one server, one database, what if response time is slow? How to optimize?

houzz面筋：
Q3: draw architectural picture for a typical web stack.
Q4: implement thread pool


onsite
数据库设计 写query
Restful Api 