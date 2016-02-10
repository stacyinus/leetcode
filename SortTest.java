import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
	private int[][] getTestSet(){
		int[] nums1 = new int[]{1,4,5,3,2,6,7,1,54,-4, Integer.MIN_VALUE};
		
		int[] nums2 = new int[]{Integer.MAX_VALUE,1,4,5,3,2,6,7,1,54,-4 };
		
		int[] nums3 = new int[]{1};
		
		int[] nums4 = new int[]{};
		
		int[] nums5 = new int[]{1,2,3,4,5,6,7};
		
		int[] nums6 = new int[]{7,6,5,4,3,2,1};
		
		int[] nums7 = new int[]{-1,-2,0,-5,-31};	
		
		int[][] testSets = {nums1,nums2,nums3,nums4,nums5,nums6,nums7};
		return testSets;
	}
	private int[][] getResultSet(){
		int[] expect1 = new int[]{Integer.MIN_VALUE,-4,1,1,2,3,4,5,6,7,54};
		
		int[] expect2 = new int[]{-4,1,1,2,3,4,5,6,7,54,Integer.MAX_VALUE};
		
		int[] expect3 = new int[]{1};
		
		int[] expect4 = new int[]{};
		
		int[] expect5 = new int[]{1,2,3,4,5,6,7};
		
		int[] expect6 = new int[]{1,2,3,4,5,6,7};
		
		int[] expect7 = new int[]{-31,-5,-2,-1,0};	
		
		int[][] resultSets = {expect1,expect2,expect3,expect4,expect5,expect6,expect7};
		return resultSets;
	}
	@Test
	public void testInsertionSort() {
		Sort sort = new Sort();
		int[][] testSets = getTestSet();
		int[][] resultSets = getResultSet();
		for(int i=0;i<testSets.length;i++){
			sort.insertionSort(testSets[i]);		
			assertArrayEquals(resultSets[i], testSets[i]);
		}
	
	}
	@Test
	public void testBubble() {
		Sort sort = new Sort();
		int[][] testSets = getTestSet();
		int[][] resultSets = getResultSet();
		for(int i=0;i<testSets.length;i++){
			sort.bubbleSort(testSets[i]);		
			assertArrayEquals(resultSets[i], testSets[i]);
		}
	}
	@Test
	public void testSelection() {
		Sort sort = new Sort();
		int[][] testSets = getTestSet();
		int[][] resultSets = getResultSet();
		for(int i=0;i<testSets.length;i++){
			sort.selectionSort(testSets[i]);		
			assertArrayEquals(resultSets[i], testSets[i]);
		}
		
	}
	@Test
	public void testMerge() {
		Sort sort = new Sort();
		int[][] testSets = getTestSet();
		int[][] resultSets = getResultSet();
		for(int i=0;i<testSets.length;i++){
			sort.mergeSort(testSets[i]);		
			assertArrayEquals(resultSets[i], testSets[i]);
		}
		
	}
}
