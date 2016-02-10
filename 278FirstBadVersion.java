/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class 278FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
    	if(n<1)
    		return -1;
        return firstBadVersion(1,n);
    }
    public int firstBadVersion(int s,int e) {
        if(s>e)
        	return -1;
        int mid = s+(e-s)/2;
        if(isBadVersion(mid)){
        	if(mid==1||!isBadVersion(mid-1))
        		return mid;
        	return firstBadVersion(s,mid-1);
        }
        else{
        	if(isBadVersion(mid+1))
        		return mid+1;
        	return firstBadVersion(mid+1,e);
        }
    }
    public int firstBadVersion(int n) {
    	int low = 1;
    	int high = n;
    	int mid = 0;
    	while(low<=high){
    		mid = (low+high)/2;
    		if(isBadVersion(mid)){
    			if(mid==1||!isBadVersion(mid-1))
    				return mid;
    			else
    				high = mid-1;
    		}
    		else
    			low = mid+1;
    	}
    	return -1;
    } 
}