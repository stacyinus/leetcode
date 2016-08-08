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

5. Unique Binary Tree leetcode 96UniqueBinarySearchTrees

6. String encode/decode: leetcode 271

7. find min value in a rotated sorted array: 153 leetcode

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

13. fib, 非要让我不用 temp 和不能多用两个数…… 

14. edit distance，本来想背dp答案的，结果没等我开口给我简化了并让我用 recursion 写 ： leetcode 72

15. 给两个sorted array求出第k个最小值： leetcode 4 变形

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