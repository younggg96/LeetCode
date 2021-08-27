package string;

// Easy

// 231

// 752

// Add to List

// Share
// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

// Please note that the string does not contain any non-printable characters.

// Example:

// Input: "Hello, my name is John"
// Output: 5
// Accepted
// 78,607
// Submissions
// 208,308

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int res = 0;
        char[] arr = s.toCharArray();        
        for(int i = 0; i < arr.length; i++) {
            if((i == 0 || arr[i - 1] == ' ') && arr[i] != ' ') {
                res++;
            }
        }
        return res;
    }
}