/*
Number of Airplanes in the Sky

Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Notice: If landing and flying happens at the same time, we consider landing should happen at first.


Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    class State implements Comparable<State>{
    	int time;
    	boolean up;
    	public State(int time, boolean up){
    		this.time = time;
    		this.up = up;
    	}
    	@Override
    	public int compareTo(State s){
    		if(time > s.time)
    			return 1;
    		else if(time < s.time )
    			return -1;
    		else {
    			if(up == s.up)
    				return 0;
    			else if(!up)
    				return -1;
    			else
    				return 1;
    		}
    	}
    }
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        List<State> list = new ArrayList<State>();
        for(Interval i: airplanes){
        	list.add(new State(i.start, true));
        	list.add(new State(i.end, false));
        }
        Collections.sort(list);
        int cur = 0;
        int max = 0;
        for(State s : list){
            // System.out.println(s.time + " " + s.up);
        	if(s.up)
        		cur++;
        	else
        		cur--;
        	max = max > cur? max : cur;
        // 	System.out.println("cur = " + cur);
        // 	System.out.println("max = " + max);
        }
        return max;
    }
}