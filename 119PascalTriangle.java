/*
119. Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class 119PascalTriangle {
	//recursive
    public List<Integer> getRow1(int rowIndex) {
		Integer[] r = new Integer[rowIndex+1];
		if(rowIndex<0)
			return new ArrayList<Integer>();
		List<Integer> lastRow = getRow(rowIndex-1);
		for(int i=0;i<(rowIndex+2)/2;i++){
			if(i == 0){
				r[0]=1;
				r[rowIndex]=1;
			}
			else{
				int value = lastRow.get(i-1)+lastRow.get(i);
				r[i]=value;
				r[rowIndex-i]=value;
			}			
		}
		return Arrays.asList(r);
    }
    //iterative
     public List<Integer> getRow(int rowIndex) {
		Integer[] r = new Integer[rowIndex+1];
		if(rowIndex<0)
			return new ArrayList<Integer>();
		for(int i=0;i<=rowIndex;i++){
			r[0]=1;
			r[i]=1;
			int temp1 = r[0];
			int temp2 = i>0?r[1]:0;
			for(int j=1;j<(i+2)/2;j++){
				r[j]= temp1+temp2;
				r[i-j]=temp1+temp2;
				temp1 = temp2;
				temp2 = r[j+1];	
			}
		}
		return Arrays.asList(r);
    }    
}