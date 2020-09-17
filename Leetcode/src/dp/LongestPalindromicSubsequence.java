package dp;

// 516. Longest Palindromic Subsequence
// Medium

// 2301

// 191

// Add to List

// Share
// Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

// Example 1:
// Input:

// "bbbab"
// Output:
// 4
// One possible longest palindromic subsequence is "bbbb".
 

// Example 2:
// Input:

// "cbbd"
// Output:
// 2
// One possible longest palindromic subsequence is "bb".
 

// Constraints:

// 1 <= s.length <= 1000
// s consists only of lowercase English letters.
// Accepted
// 131,158
// Submissions
// 243,845

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(s == null || n == 0) return 0;
        int[][] dp = new int[n][n];
        
        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
