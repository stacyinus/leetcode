class RadixSort{
	public static void main(String[] args){
		RadixSort rs = new RadixSort();
		String[] str = {"aabbb","a","ab","acc","bcd", "ba", "ag", "aaaaa"};
		print(str);
		rs.radixsort(str);
		print(str);
	}
	public void radixsort(String[] str){
		String max = getMax(str);
		for(int i = 0 ; i < max.length() ; i++)
			countSort(str, i);
	}
	public String getMax(String[] str){
		String max = str[0];
		for(int i = 1; i < str.length; i++){
				max =  str[i].length() > max.length() ? str[i] : max;
		}			
		return max;
	}
	public void countSort(String[] str, int k){
		String[] tmp = new String[str.length];
		int[] count = new int[256];
		Arrays.fill(count, 0);
		for(int i = 0; i < str.length; i++){
			if(str[i].length() > k)
				count[str[i].charAt(str[i].length() - 1 - k )]++;
			else
				count[0]++;
		}
		
		for(int i = 1; i < 256; i++)
			count[i] += count[i-1];

		for(int i = tmp.length - 1; i >= 0 ; i--){
			if(str[i].length() > k)
				tmp[--count[str[i].charAt(str[i].length() - 1 - k )]] = str[i];
			else
				tmp[--count[0]] = str[i];
		}

		for(int i = 0; i < tmp.length; i++){
			str[i] = tmp [i];
		}
	}
	// A utility function to print an array
    static void print(String[] arr)
    {
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}