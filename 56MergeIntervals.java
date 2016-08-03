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
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        Interval cur = intervals.get(0);
        for (int i = 1 ; i < intervals.size(); i ++) {
        	Interval tmp = intervals.get(i);
        	if (cur.end < tmp.start) {
        		result.add(cur);
        		cur = tmp;
        	}
        	else if (cur.end < tmp.end){
        		cur.end = tmp.end;
        	}
        }
        result.add(cur);
        return result;
    }
    public class IntervalComparator implements Comparator<Interval>{
    	@Override
    	public int compare(Interval i1, Interval i2) {
    		if (i1.start > i2.start) return 1;
    		if (i1.start < i2.start) return -1;
    		if (i1.end > i2.end) return 1;
    		if (i1.end < i2.end) return -1;
    		return 0;
    	}
    }
}