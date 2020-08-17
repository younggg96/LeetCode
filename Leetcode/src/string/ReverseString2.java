package string;

// 541. Reverse String II
// Easy

// 446

// 1273

// Add to List

// Share
// Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
// Example:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Restrictions:
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]
// Accepted
// 91,448
// Submissions
// 188,797

public class ReverseString2 {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return s;
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            reverseString(arr, start, end);
        }
        return new String(arr);
    }
    private void reverseString(char[] s, int start, int end) {
        while(end > start) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            end--;
            start++;
        }
    }
}