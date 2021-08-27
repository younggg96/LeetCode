package array;

// Given a non-empty array of integers, return the third maximum number in this array. 
// If it does not exist, return the maximum number. The time complexity must be in O(n).

// Example 1:
// Input: [3, 2, 1]

// Output: 1

// Explanation: The third maximum is 1.
// Example 2:
// Input: [1, 2]

// Output: 2

// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
// Example 3:
// Input: [2, 2, 3, 1]

// Output: 1

// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.


public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        long first = Long.MIN_VALUE; long sec = Long.MIN_VALUE; long third = Long.MIN_VALUE;
        for(int i : nums) {
            first = Math.max(first, i);
        }
        
        for(int i : nums) {
            if(i == first) continue;
            sec = Math.max(sec, i);
        }
        
        for(int i : nums) {
            if(i == first || i == sec) continue;
            third = Math.max(third, i);
        }
        
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}