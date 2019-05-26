package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author younggg
 
 Given an array of integers, 
 return indices of the two numbers 
 such that they add up to a specific target.

 You may assume that each input would have exactly one solution, 
 and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 
 */

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
//			             0 1 2 3 4 5 6
//			Output: [5,6,7,1,2,3,4]
//			         0 1 2 3 4 5 6  k = 3 
		int[] arr2 = twoSum(arr, 9);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
//		int[] temp = {0, 0};
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if(nums[i] + nums[j] == target) {
//					temp[0] = i;
//					temp[1] = j;
//					return temp;
//				}
//			}
//		}
//		
//		return temp;
		/**
		 * O(n2)
		 */
//		for (int i = 0; i < nums.length; i++) {
//	        for (int j = i + 1; j < nums.length; j++) {
//	            if (nums[j] == target - nums[i]) {
//	                return new int[] { i, j };
//	            }
//	        }
//	    }
//	    throw new IllegalArgumentException("No two sum solution");
	    
	    /**
	     * O(n)
	     */
	    
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
        
    }
}
