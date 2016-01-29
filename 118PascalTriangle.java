/*
118. Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class 118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0)
        	return result;
        for(int i=0;i<numRows;i++){
        	Integer[] l = new Integer[i+1];//here, it has to be Integer instead of int, because
        								//Arrays.asList won't convert the int to Integer.
        	List<Integer> lastrow = i>0?result.get(i-1):null;
        	for(int j=0;j<(l.length+1)/2;j++){
        		if(j==0){
        			l[0]=1;
        			l[l.length-1]=1;
        		}
        		else{        			
        			l[j]=lastrow.get(j-1)+lastrow.get(j);
        			l[l.length-1-j]=l[j];
        		}
        	}
        	List<Integer> currentrow = Arrays.asList(l);
        	result.add(currentrow);
        }
        return result;
    }
}