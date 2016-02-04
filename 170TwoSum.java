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