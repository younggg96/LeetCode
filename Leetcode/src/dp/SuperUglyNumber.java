package dp;

import java.util.Arrays;

// 313. Super Ugly Number
// Medium

// 671

// 146

// Add to List

// Share
// Write a program to find the nth super ugly number.

// Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

// Example:

// Input: n = 12, primes = [2,7,13,19]
// Output: 32 
// Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
//              super ugly numbers given primes = [2,7,13,19] of size 4.
// Note:

// 1 is a super ugly number for any given primes.
// The given numbers in primes are in ascending order.
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
// Accepted
// 79,404
// Submissions
// 175,456

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0) return 0;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 1;
        int[] index = new int[primes.length];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], res[index[j]] * primes[j]);
            }
            for(int j = 0; j < primes.length; j++) {
                if(res[i] == res[index[j]] * primes[j]) index[j]++;
            }    
        }
        return res[n - 1];
    }
}
