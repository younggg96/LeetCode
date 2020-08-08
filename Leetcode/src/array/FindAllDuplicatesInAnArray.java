package array;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
// Medium

// 2266

// 150

// Add to List

// Share
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

// Could you do it without extra space and in O(n) runtime?

// Example:
// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex] < 0) res.add(Math.abs(newIndex + 1));
            nums[newIndex] *= -1;
        }
        return res;
    }
    
}