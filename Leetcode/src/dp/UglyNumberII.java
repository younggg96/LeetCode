package dp;

// 264. Ugly Number II
// Medium

// 2061

// 127

// Add to List

// Share
// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

// Example:

// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
// Note:  

// 1 is typically treated as an ugly number.
// n does not exceed 1690.
// Accepted
// 183,554
// Submissions
// 435,473

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        int f2 = 0, f3 = 0, f5 = 0;
        int str2 = 1, str3 = 1, str5 = 1;
        
        for(int i = 0; i < n; i++) {
            res[i] = Math.min(Math.min(str2, str3), str5);
            if(str2 == res[i]) str2 = 2 * res[f2++];
            if(str3 == res[i]) str3 = 3 * res[f3++];
            if(str5 == res[i]) str5 = 5 * res[f5++];
        }
        
        return res[n - 1];
    }
}
