package array;

import java.util.Arrays;

/**
 * 
 * @author younggg
 
 Given an array nums of n integers and an integer target, 
 find three integers in nums such that the sum is closest to target. 
 Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 
 */

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		
//		int result = 0;
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length - 2; i++) {
//			int low = i + 1;
//			int high = nums.length -1;
//			int res = nums[0] + nums[1] + nums[nums.length - 1];
//			int sum = nums[i] + nums[low] + nums[high];
//			result = Math.abs(Math.min(result, (sum - target)));
//			while(low < high) {
//				if (result == Math.abs(Math.min(result, (sum - target)))) {
//					return result;
//				} else if(result > Math.abs(Math.min(result, (sum - target)))) {
//					low++;
//				} else {
//					high--;
//				}
//			}
//			
//		}
//		
//		return result;
		
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1;
			int high = nums.length -1;
			while(low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if(sum > target) {
					high--;
				} else {
					low++;
				}
				if(Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		
		return res;
        
    }
}
