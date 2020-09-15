package dp;

// 494. Target Sum
// Medium

// 2960

// 120

// Add to List

// Share
// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

// Find out how many ways to assign symbols to make sum of integers equal to target S.

// Example 1:

// Input: nums is [1, 1, 1, 1, 1], S is 3. 
// Output: 5
// Explanation: 

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// There are 5 ways to assign symbols to make the sum of nums be target 3.
 

// Constraints:

// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.
// Accepted
// 181.6K
// Submissions
// 393.6K

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        for(int n : nums) sum += n;
        if(S > sum || (S + sum) % 2 == 1) return 0;
        return helper(nums, (S + sum) / 2);
    }
    
    private int helper(int[] nums, int sum) {
        int len = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int i = 1; i <= len; i++) {
            for(int j = sum; j >= 0; j--) {
                if(j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
                else {
                    dp[j] = dp[j];
                }
            }
        }
        
        return dp[sum];
    }
}
