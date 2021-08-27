package dp;

// 576. Out of Boundary Paths
// Medium

// 584

// 136

// Add to List

// Share
// There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.

// Example 1:

// Input: m = 2, n = 2, N = 2, i = 0, j = 0
// Output: 6
// Explanation:

// Example 2:

// Input: m = 1, n = 3, N = 3, i = 0, j = 1
// Output: 12
// Explanation:

 

// Note:

// Once you move the ball out of boundary, you cannot move it back.
// The length and height of the grid is in range [1,50].
// N is in range [0,50].

public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N <= 0) return 0;
        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        dp[i][j] = 1;
        int res = 0;
        for(int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for(int r = 0; r < m; r++) {
                for(int c = 0; c < n; c++) {
                    for(int[] d: dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if(nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + dp[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        return res;
        
    }
}
