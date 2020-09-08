package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 368. Largest Divisible Subset
// Medium

// 1478

// 72

// Add to List

// Share
// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

// Si % Sj = 0 or Sj % Si = 0.

// If there are multiple solutions, return any subset is fine.

// Example 1:

// Input: [1,2,3]
// Output: [1,2] (of course, [1,3] will also be ok)
// Example 2:

// Input: [1,2,4,8]
// Output: [1,2,4,8]
// Accepted
// 98.6K
// Submissions
// 259.9K

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        
        int n  = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        int pre = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(dp[i] == max && (pre == -1 || pre % nums[i] == 0)) {
                res.add(nums[i]);
                pre = nums[i];
                max--;
            }
        }
        return res;
    }
}
