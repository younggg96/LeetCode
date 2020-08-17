package string;

// 557. Reverse Words in a String III
// Easy

// 1077

// 87

// Add to List

// Share
// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Note: In the string, each word is separated by single space and there will not be any extra space in the string.

public class ReverseString3 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++) {
            char[] strArr = arr[i].toCharArray();
            reverseString(strArr, 0, strArr.length - 1);
            arr[i] = new String(strArr);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
            if(i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
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