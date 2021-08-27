package dp;

// 5. Longest Palindromic Substring
// Medium

// 7942

// 570

// Add to List

// Share
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: "cbbd"
// Output: "bb"
// Accepted
// 1M
// Submissions
// 3.5M
// Seen this question in a real interview before?

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int count = 1;
        int start = 0;
        Boolean[][] dp = new Boolean[len][len];
        
        if(len <= 0 || s == null) return "";
        if(len < 2) return s;
        
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        for(int j = 1; j < len; j++) {
            for(int i = 0; i < j; i++) {
                if(s.charAt(j) != s.charAt(i)) {
                    dp[j][i] = false;
                } else {
                    if(j - i < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j - 1][i + 1];
                    }
                }
                
                if(dp[j][i] && j - i + 1 > count) {
                    count = j - i + 1;
                    start = i;
                }
            }    
        }
        
        return s.substring(start, start + count);
    }
}
