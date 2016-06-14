/*
Nuts & Bolts Problem

Given a set of n nuts of different sizes and n bolts of different sizes. 
There is a one-one mapping between nuts and bolts. 
Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

We will give you a compare function to compare nut with bolt.


Example
Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

Your code should find the matching bolts and nuts.

one of the possible return:

nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

we will tell you the match compare function. If we give you another compare function.

the possible return is the following:

nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

So you must use the compare function that we give to do the sorting.

The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/

/*
THis is not finished....couldn't get it passed....
check this out.
http://www.jiuzhang.com/solutions/nuts-bolts-problem/
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null || bolts == null )
        	return;
       	sort(nuts, bolts, 0, nuts.length - 1, compare);
    	

    }
    public void sort(String[] nuts, String[] bolts, int i, int j, NBComparator compare){
    	int index = partition(nuts, bolts, i, j, nuts[0],compare);
    	if(i < index - 1)
    		partition(nuts, bolts, i, index - 1, nuts[i],compare);
    	if(j > index)
    		partition(nuts, bolts, index, j, nuts[index],compare);       	
    }
    public int partition(String[] nuts, String[] bolts, int i, int j, String pivot, NBComparator compare){
    	int s = i, e = j;
    	// System.out.println(Arrays.toString(bolts));
    	// System.out.println("pivot is " + pivot);
    	while(s <= e){
    		while(s<=e &&compare.cmp(pivot, bolts[s]) < 0)
    			s++;
    		//System.out.println("e is "+ e);
    		while(s<=e && compare.cmp(pivot, bolts[e]) > 0)
    			e--;
    		if(s <= e){
    			String tmp = bolts[s];
    			bolts[s] = bolts[e];
    			bolts[e] = tmp;
    			s++;
    			e--;
    		}
    	}
    	String  = (s >= 0 && compare.cmp(pivot, bolts[s]) == 0 )? bolts[s]: bolts[e];
    	int result = s;
    	s = i, e = j;
    	// System.out.println(Arrays.toString(bolts));
    	// System.out.println("pivot is " + pivot);
    	while(s <= e){
    		while(s<=e &&compare.cmp(nuts[s], newPivot) < 0)
    			s++;
    		//System.out.println("e is "+ e);
    		while(s<=e && compare.cmp(nuts[e], newPivot) > 0)
    			e--;
    		if(s <= e){
    			String tmp = bolts[s];
    			bolts[s] = bolts[e];
    			bolts[e] = tmp;
    			s++;
    			e--;
    		}
    	}
    	// System.out.println("s is " + s);
    	// System.out.println("e is " + e);
    	// System.out.println("bolts[s] is " + bolts[s]);
    	// System.out.println("bolts[s] == pivot " + compare.cmp(bolts[s], pivot));	
    	return result;	
    }
};