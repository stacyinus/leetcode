/*
57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
	思路： 一共有3类 intervals: 在newinterval前，与newInterval没有overlap。
							  与newInterval有overlap
							  在newinterval后，与newInterval没有overlap。
		  merge and update the new interval, in the mean time, track the index where to insert the new interval。
	loop through the list of intervals:
	1.while newInterval.start > current.end, add into list
	2.now newInterval.start <= current.end, overlapping find, need to merge
		1) find newstart: smaller(newInterval.start, current.start).
		2) find newEnd: skip all the intervals that are covered by newInterval (those current.end <= newInterval.end)
						now, if current.start <= newInterval.end, newEnd = current.end; 
	3. now add everything that is left.
	4. insert the new interval to the right place. 
		
*/
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int newStart = newInterval.start;
		int newEnd = newInterval.end;
		int pos = 0; //where to insert the new interv
		int i = 0;
		while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
			result.add(intervals.get(i));
			i++;
			pos++;
		}	
		if(i < intervals.size()) {
			newStart = Math.min(newStart, intervals.get(i).start);
			while (i < intervals.size() && newInterval.end > intervals.get(i).end) {
				i++;
			}	
			if (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
				newEnd = intervals.get(i++).end;
			}
		}
		while(i < intervals.size() && newInterval.end < intervals.get(i).start) {
			result.add(intervals.get(i));
			i++;
		}			
		result.add(pos, new Interval(newStart, newEnd));
		return result;
	}
}