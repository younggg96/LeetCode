package dp;

// 474. Ones and Zeroes
// Medium

// 1124

// 245

// Add to List

// Share
// Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.

// Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 

// Example 1:

// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".
// Example 2:

// Input: strs = ["10","0","1"], m = 1, n = 1
// Output: 2
// Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 

// Constraints:

// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] consists only of digits '0' and '1'.
// 1 <= m, n <= 100
// Accepted
// 51,604
// Submissions
// 120,037

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if(len == 0 || strs == null) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs) {
            int[] c = helper(str);
            for(int i = m; i >= c[0]; i--) {
                for(int j = n; j >= c[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - c[0]][j - c[1]]);
                }
            }
        }
        return dp[m][n];

    }
    
    private int[] helper(String str) {
        int[] count = new int[2];
        char[] charArr = str.toCharArray(); 
        for(char c : charArr) {
            if(c == '0') count[0]++;
            else count[1]++;
        }
        return count;
    }
}
