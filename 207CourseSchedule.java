/*
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/
/*
	Topological Sort-BFS: 思路：	1. count每一门课有几个prerequisites
						   		2. 从没有prerequisites的课上起（push into queue），每上一门课，搜索哪些课以这一门为prerequisite，将count-1。 
						   	  		如果count=0，表示这门课可以被上（push into queue）. 
						   		3. repeat直到没有课可以上。
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] numOfP = new int[numCourses];//number of prerequisites needed for each course
		for (int i = 0; i < prerequisites.length; i ++) {
			numOfP[prerequisites[i][0]]++;
		}        
		//System.out.println("numOfP[] = " + Arrays.toString(numOfP));
		Queue<Integer> courseCanTake = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (numOfP[i] == 0) {
				courseCanTake.add(i);
			}
		}
		//System.out.println("courseCanTake = " + Arrays.toString(courseCanTake.toArray()));
		int numCoursesCanTake = courseCanTake.size();
		//System.out.println("numCoursesCanTake = " + numCoursesCanTake);
		while (!courseCanTake.isEmpty()) {
			int course = courseCanTake.poll();
			for (int i = 0; i < prerequisites.length; i ++) {
				if (prerequisites[i][1] == course) {
					numOfP[prerequisites[i][0]]--;
					if (numOfP[prerequisites[i][0]] == 0) {
						courseCanTake.add(prerequisites[i][0]);
						numCoursesCanTake++;
					}
				}
				
			}
		}
		//System.out.println("numCoursesCanTake = " + numCoursesCanTake);
		return numCoursesCanTake == numCourses;
    }
}