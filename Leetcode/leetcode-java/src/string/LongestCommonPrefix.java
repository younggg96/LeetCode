package string;

// 14. Longest Common Prefix
// Easy

// 2770

// 1913

// Add to List

// Share
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
// Note:

// All given inputs are in lowercase letters a-z.



public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            prefix = helper(prefix, strs[i]);
        }
        return prefix;
    }
    
    private String helper(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        int count = 0;
        while(count < min && str1.charAt(count) == str2.charAt(count)) {
            count++;
        }
        return str1.substring(0, count);
    } 
}