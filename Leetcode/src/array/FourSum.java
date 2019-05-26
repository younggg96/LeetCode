package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 3; i++) {
			if(i > 0 && nums[i] == nums[i - 1] ) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int low = j + 1;
				int high = nums.length - 1;
				int sum = 0 - nums[i] - nums[j];
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while(low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while(low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
					} else if(nums[low] + nums[high] < sum) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		
		
		return res;
        
    }
}
