import java.util.ArrayList;

public class MaxHeap{
	private ArrayList<Integer> heap = new ArrayList<Integer>();
	public static void main(String[] args){
		int[] nums = new int[]{Integer.MAX_VALUE,1,4,5,3,2,6,7,1,54,-4};
		MaxHeap heap = new MaxHeap();
		int[] result = heap.heapSort(nums);
		heap.printArray(result);
	}
	private void heapifyUp(){
		int i = heap.size()-1;
		while(i>0){
			if(heap.get(i)>heap.get((i-1)/2)){
				int tmp = heap.get(i);
				heap.set(i,heap.get((i-1)/2));
				heap.set((i-1)/2,tmp);
			}
			else
				break;
			i=(i-1)/2;
		}

	}
	public void add(int i){
		heap.add(i);
		//printArray(heap);
		heapifyUp();
		printArray(heap);
	}
	public int peek(){
		if(heap.size()==0)
			return Integer.MIN_VALUE;
		return heap.get(0);
	}
	public int pop(){
		if(heap.size()==0)
			return Integer.MIN_VALUE;
		int max = heap.get(0);
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		heapifyDown();
		return max;
	}
	private void heapifyDown(){
		int i = 0;
		while(2*i+1<heap.size()){
			int l = heap.get(2*i+1);
			int r = Integer.MIN_VALUE;
			int tmp = heap.get(i);
			if(2*i+2<heap.size())
				r = heap.get(2*i+2);
			if(l>r){
				heap.set(i,l);
				heap.set(2*i+1,tmp);
				i=2*i+1;
			}
			else if(2*i+2<heap.size()){
				heap.set(i,r);
				heap.set(2*i+2,tmp);
				i=2*i+2;
			}
		}		
	}
	public int[] heapSort(int[] set){
		heap = new ArrayList<Integer>();
		if(set ==null) return null;
		for(int i=0;i<set.length;i++)
			add(set[i]);
		int[] result = new int[heap.size()];
		int l = heap.size();
		for(int i=0;i<l;i++)
			result[i]=pop();
		return result;
	}
	private void printArray(int[] nums){
		for(int i: nums){
			System.out.print(i+"    ");
		}
		System.out.println("");
	}
	private void printArray(ArrayList<Integer> nums){
		for(int i: nums){
			System.out.print(i+"    ");
		}
		System.out.println("");
	}


}