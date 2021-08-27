package dp;

// 639. Decode Ways II
// Hard

// 453

// 521

// Add to List

// Share
// A message containing letters from A-Z is being encoded to numbers using the following mapping way:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

// Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

// Also, since the answer may be very large, you should return the output mod 109 + 7.

// Example 1:
// Input: "*"
// Output: 9
// Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
// Example 2:
// Input: "1*"
// Output: 9 + 9 = 18
// Note:
// The length of the input string will fit in range [1, 105].
// The input string will only contain the character '*' and digits '0' - '9'.
// Accepted
// 32,593
// Submissions
// 122,041


public class DecodeWaysII {
    public int numDecoding(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        if(n == 0 || s.charAt(0) == '0')  return 0;
        long[] dp = new long[n + 1];
        char[] a = (" " + s).toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(a[i] == '*'){
                dp[i] = (9 * dp[i - 1]) % mod;
                if(a[i - 1] == '1') dp[i] = (dp[i] + 9 * dp[i - 2]) % mod;
                else if(a[i - 1] == '2') dp[i] =(dp[i] +  6 * dp[i - 2]) % mod;
                else if(a[i - 1] == '*') dp[i] =(dp[i] + 15 * dp[i - 2]) % mod;
            }else if(a[i] == '0'){
                if(a[i - 1] == '1' || a[i - 1] == '2') dp[i] = dp[i - 2];
                else if(a[i - 1] == '*') dp[i] = 2 * dp[i - 2] % mod;
                else return 0;
            }else{
                dp[i] = dp[i - 1];
                if(a[i - 1] == '1') dp[i] = (dp[i] + dp[i - 2]) % mod;
                else if(a[i - 1] == '2' && a[i] - '0' >= 1 && a[i] - '0' <= 6) dp[i] = (dp[i] + dp[i - 2]) % mod;
                else if(a[i - 1] == '*'){
                    if( a[i] - '0' >= 7 && a[i] - '0' <= 9) dp[i] = (dp[i] + dp[i - 2]) % mod;
                    else dp[i] = (dp[i] + 2 * dp[i - 2]) % mod;
                }
            }

        }
        return (int) (dp[n] % mod);
    }
}