package array;

/**
 * 
 * @author younggg
 
 Given nums = [1,1,2],

Your function should return length = 2, 
with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

 
 Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, 
with the first five elements of nums being modified to 0, 1, 2, 3, 
and 4 respectively.
It doesn't matter what values are set beyond the returned length.
 */

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int arr[] = {0, 0, 2, 2, 2, 3, 4, 4, 5, 5, 5, 6};
		System.out.println(removeDuplicates(arr));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i - 1] != nums[i]) {
				count++;
			}
		}
		return count;
        
    }
}
