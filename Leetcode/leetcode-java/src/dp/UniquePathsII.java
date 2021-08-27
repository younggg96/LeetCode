package dp;

// 63. Unique Paths II
// Medium

// 1949

// 253

// Add to List

// Share
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// Now consider if some obstacles are added to the grids. How many unique paths would there be?



// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// Note: m and n will be at most 100.

// Example 1:

// Input:
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// Output: 2
// Explanation:
// There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
// Accepted
// 312.8K
// Submissions
// 901.6K
// Seen this question in a real interview before?

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ways = new int[m][n];
        
         for (int i = 0; i < m; i++) {
	        	if(obstacleGrid[i][0] == 1) {
	        		break;
	        	}
	        	ways[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
			if(obstacleGrid[0][i] == 1) {
				break;
			}
			ways[0][i] = 1;
		}
        
       
        
        for (int i = 1; i < m; i++) {
        		for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 1) {
					continue;
				}
				ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
			}
			
		}
        return ways[m - 1][n - 1];
    }
}
