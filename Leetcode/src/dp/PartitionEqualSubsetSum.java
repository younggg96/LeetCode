package dp;

// 416. Partition Equal Subset Sum
// Medium

// 3029

// 74

// Add to List

// Share
// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Note:

// Each of the array element will not exceed 100.
// The array size will not exceed 200.
 

// Example 1:

// Input: [1, 5, 11, 5]

// Output: true

// Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

// Example 2:

// Input: [1, 2, 3, 5]

// Output: false

// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Accepted
// 200.4K
// Submissions
// 456.6K


public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0 || nums == null) return true;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        boolean[] dp = new boolean[sum + 1];
        if(sum % 2 != 0) return false;
        sum /= 2;
        dp[0] = true;
        for(int i = 0; i < len - 1; i++) {
            for(int j = sum; j >= 0; j--) {
                if(j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
