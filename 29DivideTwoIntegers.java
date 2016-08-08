/*
29. Divide Two Integers 
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

*/
//http://blog.csdn.net/zmazon/article/details/8262185

/*
	写完之后，务必思考overflow case, 注意Integer.MIN_VALUE / -1 = Integer.MAX_VALUE
	eg: 18/2
	18 - 2 = 16 （+1）
	16 - 4 = 12 （+2）
	12 - 8 = 4  （+4）
	4 < 16 so start over
	4 - 2 = 2 （+1）
	2 < 4 so start over
	2 - 2 = 0 （+1）
*/

//Second Round: still missing one overflow case: dividend == Integer.MIN_VALUE && divisor == -1
public class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean pos = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        long dividendNew = Math.abs((long)dividend);
        long divisorNew = Math.abs((long)divisor);
        while (dividendNew >= divisorNew) {
            int tmpCount = 1;
            long div = divisorNew;
            while (dividendNew >= div) {
                dividendNew -= div;
                count += tmpCount;
                tmpCount = tmpCount << 1;
                div = div << 1;
            }
        }
        return pos ? count : -1 * count;
    }
}

public class Solution {
    public int divide(int dividend, int divisor) {
    	if(divisor == 0)
    		return Integer.MAX_VALUE;
		long divd = Math.abs((long)dividend);//Here you have to cast dividend to long before getting the abs value
		long divr = Math.abs((long)divisor);
		long result = 0;// Here you need to use long instead of int to avoid overflow
		while(divd>=divr){
			for(long tmp = divr, count=1;divd>=tmp;count>>=1, tmp>>=1){
				divd -= tmp;
				result += count;
			}
    	}
    	result = ((dividend > 0) & (divisor > 0))? result: -result;
    	//Here you have to check overflow.
    	if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
    		return Integer.MAX_VALUE;
    	return (int)result;
	}
}


