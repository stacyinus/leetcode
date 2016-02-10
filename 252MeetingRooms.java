/*
Problem Description:

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false. 
*/
public class 252MeetingRooms{
	public static void main(String[] args){
		int[][] schedule = {{0,1},{15,20},{2,3},{22,23},{4,7},{16,23}};
		MeetingRoom r = new MeetingRoom();
		System.out.println(r.canAttendAll(schedule));
	}
	public boolean canAttendAll(int[][] schedule){
		int[][] copy = new int[schedule.length][2];
		sortByStartTime(schedule,copy,0,schedule.length-1);
		System.out.println(Arrays.deepToString(schedule));
		for(int i=0;i<schedule.length-1;i++)
			if(schedule[i][1]>schedule[i+1][0])
				return false;
		return true;
	}	
	//merge sort
	private void sortByStartTime(int[][] schedule,int[][] copy, int l, int r){
		if(l>=r) return;
		int mid = l+(r-l)/2;
		sortByStartTime(schedule,copy,l,mid);
		sortByStartTime(schedule,copy,mid+1,r);
		merge(schedule,copy,l,mid,r);
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
				if(i1>mid||i2<=r && copy[i1][0]>copy[i2][0]){
					schedule[k][0]=copy[i2][0];
					schedule[k][1]=copy[i2][1];
					i2++;
				}
				else{
					schedule[k][0]=copy[i1][0];
					schedule[k][1]=copy[i1][1];
					i1++;
				}
				k++;
			}
	}
}