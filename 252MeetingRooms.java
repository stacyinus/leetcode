/*
Problem Description:

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false. 
*/
public class 252MeetingRooms{
	public boolean canAttendAll(int[][] schedule){
		int[][] copy = schedule.clone();
		sortByStartTime(schedule,copy,0,schedule.length-1);
		for(int i=0;i<schdule.length-1;i++)
			if(schedule[i][1]>schedule[i+1][0])
				return false;
		return true;
	}	
	//merge sort
	private void sortByStartTime(int[][] schedule,int[][] copy, int l, int r){
		if(l>=r) return;
		int mid = l+(r-1)/2;
		sortByStartTime(schedule,copy,l,mid);
		sortByStartTime(schedule,copy,mid+1,r);
		merge();
	}
	private void merge(int[][] schedule,int[][] copy, int l, int mid, int r){
			for(int i=l;i<=r;i++){
				copy[i][0]=schedule[i][0];
				copy[i][1]=schedule[i][1];
			}
			int i1=l;
			int i2=mid+1;
			int k = i1;
			while(i1<=mid||i2<=r){
				
			}
	}
}