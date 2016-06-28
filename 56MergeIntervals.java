/*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].	
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*
	结题思路：	注意当merge两个interval的时候，不能马上add to list,因为可能后面还有overlap。
				应该Keep reference of current interval， 当no overlap时，add to list.
				当有overlap时，merge,然后让cur指向merge之后的 interval 然后repeat之前的操作。
				1. sort intervals first.
			 	2. if current interval has no overlap with its next, move pointer.
			 	3. if there's overlap, merge the interval and keep the 
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	return result;
        }
        Collections.sort(intervals, new MyComparator());
		int j = 1; //point to the next interval that compares with cur.
		Interval cur = intervals.get(0);
		while (j < intervals.size()) { 
			if (cur.end < intervals.get(j).start) {//if no overlap。
				result.add(cur);
				cur = intervals.get(j);
				j++;
			}
			else { //merge started
				int start = cur.start;
				int end = cur.end;
				while (j < intervals.size() && cur.end >= intervals.get(j).end) {
					j++;
				}
				if (j < intervals.size() && cur.end >= intervals.get(j).start) {
					end = intervals.get(j++).end;
				}
				cur = new Interval(start,end);
			}
		}        
		result.add(cur);
		return result;
    }

    public class MyComparator implements Comparator<Interval> {
    	@Override
    	public int compare(Interval i1, Interval i2) {
    		if(i1.start > i2.start)
    			return 1;
    		else if(i1.start < i2.start)
    			return -1;
    		else if(i1.end > i2.end) 
    			return 1;
    		else if(i1.end < i2.end)
    			return -1;
    		return 0;

    	}
    }
}