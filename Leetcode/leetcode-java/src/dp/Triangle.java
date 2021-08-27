package dp;

import java.util.List;

// 120. Triangle
// Medium

// 2225

// 261

// Add to List

// Share
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle

// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:

// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0 || triangle == null) return 0;
        int[] dp = new int[len + 1];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> arr = triangle.get(i);
            for(int j = 0; j < arr.size(); j++) {
                dp[j] = arr.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
