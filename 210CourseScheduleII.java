/*
210. Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/
/*
	Topological Sort-BFS: 思路：	1. count每一门课有几个prerequisites
						   		2. 从没有prerequisites的课上起（push into queue），每上一门课，搜索哪些课以这一门为prerequisite，将count-1。 
						   	  		如果count=0，表示这门课可以被上（push into queue）. 
						   		3. repeat直到没有课可以上。
*/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] numOfP = new int[numCourses];//number of prerequisites needed for each course
		ArrayList<Integer>[] dependants = new ArrayList[numCourses];//which courses are dependent on course i.
		for (int i = 0; i < prerequisites.length; i ++) {
			numOfP[prerequisites[i][0]]++;
			ArrayList<Integer> list = dependants[prerequisites[i][1]];
			if ( list == null) {
				list = new ArrayList<Integer>();
				dependants[prerequisites[i][1]] = list;
			}
			list.add(prerequisites[i][0]);
		}        
		Queue<Integer> courseCanTake = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (numOfP[i] == 0) {
				courseCanTake.add(i);
			}
		}
		int[] result = new int[numCourses];
		int index = 0;
		while (!courseCanTake.isEmpty()) {
			int course = courseCanTake.poll();
			result[index++] = course;
			if(dependants[course] == null)
			    continue;
			for( Integer dp : dependants[course] ){
				numOfP[dp]--;
				if (numOfP[dp] == 0) {
					courseCanTake.add(dp);					
				}			
			}
		}
		if (index < numCourses) return new int[0];
		return result;
    }
}