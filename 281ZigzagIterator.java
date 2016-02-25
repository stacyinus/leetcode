/*
281. Zigzag Iterator
Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:
v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

*/

public class ZigzagIterator {
	List<List<Integer>> lists;
	int indexOfLists;
	int[] index;
	int numOfElementsLeft;

	public ZigzagIterator(List<List<Integer>> lists){
		this.lists = lists;
		this.index = new int[lists.size()];
		for(int i:this.index)
			this.index[i]=-1;
		this.indexOfLists = -1;
		for(List<Integer> l:lists)
			this.numOfElementsLeft += l.size();
		
	}

	public boolean hasNext(){
		return numOfElementsLeft == 0; 
	}

	public void next(){
		if(!hasNext())
			return;
		indexOfLists = indexOfLists+1>=lists.size()?indexOfLists+1-lists.size():indexOfLists+1;
		while(index[indexOfLists]+1>=list.get(indexOfLists).size())
			indexOfLists = indexOfLists+1>=lists.size()?indexOfLists+1-lists.size():indexOfLists+1;
		index[indexOfLists] = index[indexOfLists]+1;
		numOfElementsLeft--;
	}
}