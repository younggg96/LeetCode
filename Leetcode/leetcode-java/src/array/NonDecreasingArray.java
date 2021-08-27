package array;


// 665. Non-decreasing Array
// Easy

// Add to List

// Share
// Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

// Example 1:

// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// Example 2:

// Input: nums = [4,2,1]
// Output: false
// Explanation: You can't get a non-decreasing array by modify at most one element.
 

// Constraints:

// 1 <= n <= 10 ^ 4
// - 10 ^ 5 <= nums[i] <= 10 ^ 5

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if(len < 3) return true;
        int count = 0;
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                count++;
                if(count > 1) return false;
                if(i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}