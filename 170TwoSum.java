/*
170.Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
/*
	There are different ways to implement, one important question is: does it allow duplicate numbers to be added
	- if no, you can just use one HashSet(no need to use map) to store the value, and the find function will just loop 
	through each value i in the set and check if there exists a value target - i in the set. In this case, add function is 
	O(1), find is O(n)
	- if yes,you can choose 2 ways: 
		- use an ArrayList, and when add a new value, insert into the right position so that the list is sorted in acending order. So add function is 
		  O(log n), then use 2 pointers to solve the find function(greedy), O(n)
		- use an ArrayList, just use the add function of ArrayList to add new value O(1), and create a new HashSet and loop through all values in the list
		  to implement the find method, which is O(n) see the implementation below.
*/
public class 170TwoSum {
	ArrayList<Integer> list = new ArrayList<Integer>();
	//O(1)
	public void add(int i){
		list.add(i);
	}
	//O(n)
	public boolean find(int x){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<list.size();i++){
			if(set.contains(x-list.get(i)))
				return true;
			set.add(list.get(i));
		}
		return false;
	}
}