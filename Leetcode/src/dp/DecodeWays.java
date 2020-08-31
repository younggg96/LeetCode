package dp;

// 91. Decode Ways
// Medium

// 2935

// 2997

// Add to List

// Share
// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

// Example 1:

// Input: "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// Example 2:

// Input: "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
// Accepted
// 422,813
// Submissions
// 1,704,502

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] res = new int[len + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= len; i++) {
            if(s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                res[i] += res[i - 2];
            }
            if(s.charAt(i - 1) != '0') {
                res[i] += res[i - 1];
            }
        }
        return res[len];
    }
}