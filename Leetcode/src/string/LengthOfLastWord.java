package string;

// 58. Length of Last Word
// Easy

// 694

// 2518

// Add to List

// Share
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a maximal substring consisting of non-space characters only.

// Example:

// Input: "Hello World"
// Output: 5
 

// Accepted
// 388,542
// Submissions
// 1,192,986


public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                count++;
            } else {
                if(count == 0) continue;
                break;
            }
        }
        return count;
    }
}