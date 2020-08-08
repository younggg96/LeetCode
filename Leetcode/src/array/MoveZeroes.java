package array;

import java.util.Arrays;


// 283. Move Zeroes
// Easy

// Add to List

// Share
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int len = nums.length;
        int start = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }
        Arrays.fill(nums, start, len, 0);
    }
}