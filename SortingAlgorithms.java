class Sort{
	public static void main(String[] args){
		int[] nums = new int[]{1,4,5,3,2,6,7,1,54,-4};
		Sort sort = new Sort();
		sort.insertionSort(nums);
		sort.printArray(nums);
	}

	public void quickSort(int[] nums){
		if(nums.length==0||nums.length==1)
			return;
		quickSort(nums,0,nums.length-1);
	}

	public void quickSort(int[] nums, int l, int r){
		int index = partition(nums,l,r);
		if(l<index-1)
			quickSort(nums,l,index-1);
		if(r>index)
			quickSort(nums,index,r);
	}
	private int partition(int[] nums, int l, int r){
		int i=l;
		int j=r;
		int pivot = nums[l+(r-l)/2];
		while(i<=j){//why it has to be i<=j not i<j?
			while(nums[i]<pivot)
				i++;
			while(nums[j]>pivot)
				j--;
			if(i<=j){//why it has to be i<=j not i<j?
				int tmp = nums[i];
				nums[i]=nums[j];
				nums[j]=tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	//merge sort, Time O(nlogn), Space O(n);
	//constant O(nlogn)
	public void mergeSort(int[] nums){
		int[] copy = new int[nums.length];
		mergeSort(nums,copy,0,nums.length-1);
	}
	private void mergeSort(int[] nums, int[] copy, int l, int r){
		if(l>=r) return;
		int mid = l+(r-l)/2;
		mergeSort(nums,copy, l,mid);
		mergeSort(nums,copy,mid+1,r);
		merge(nums,copy,l,mid,r);
	}
	private void merge(int[] nums, int[] copy, int l, int mid, int r){
		int i1=l;
		int i2=mid+1;
		int i = i1;
		for(int tmp=l;tmp<=r;tmp++)
			copy[tmp]=nums[tmp];
		while(i1<=mid||i2<=r){
			if(i1>mid||i2<=r&&copy[i1]>copy[i2]){
				nums[i] = copy[i2];
				i2++;
			}
			else{
				nums[i] = copy[i1];
				i1++;
			}
			i++;
		}
	}

	//insertion sort, Time O(n2), Space O(1);
	//Best case O(n)----when it's already sorted, average O(n2), worst case O(n2)----when it's reversely sorted;
	public void insertionSort(int[] nums){
		for(int i=1;i<nums.length;i++)
			doInsert(nums,i);
	}

	private void doInsert(int[] nums, int index){
		for(int i=index-1;i>=0;i--){
			if(nums[i]<=nums[index]) break;
			int tmp = nums[i];
			nums[i]=nums[index];
			nums[index]=tmp;
			index--;
		}
	}
	//Selection sort, Time O(n2), Space O(1);
	//Best case O(n2), average O(n2), worst case O(n2);
	public void selectionSort(int[] nums){
		for(int i=0;i<nums.length-1;i++){
			int minIndex = i;
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<nums[minIndex])
					minIndex = j;
			}	
			if(minIndex!=i){
				int tmp = nums[i];
				nums[i]=nums[minIndex];
				nums[minIndex]=tmp;				
			}
		}
	}

	//bubble sort, Time O(n2), Space O(1);
	//Best case O(n2), average O(n2), worst case O(n2);
	public void bubbleSort(int[] nums){
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<nums.length-1;j++){
				if(nums[j+1]<nums[j]){
					int tmp = nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=tmp;
				}
			}
		}
	}

	private void printArray(int[] nums){
		for(int i: nums){
			System.out.print(i+"    ");
		}
		System.out.println("");
	}
}