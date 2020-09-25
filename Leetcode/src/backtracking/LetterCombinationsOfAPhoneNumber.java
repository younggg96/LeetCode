package backtracking;

import java.util.ArrayList;
import java.util.List;

// 17. Letter Combinations of a Phone Number
// Medium

// 4403

// 441

// Add to List

// Share
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



// Example:

// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:

// Although the above answer is in lexicographical order, your answer could be in any order you want.


public class LetterCombinationsOfAPhoneNumber {
    List<String> res = new ArrayList<String>();
    String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if(digits == null || len == 0) return res;

        helper(digits, 0);
        return res;
    }
    
    private void helper(String digits, int index) {
        if(digits.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        String str = arr[digits.charAt(index) - '2'];
        for(char c : str.toCharArray()) {
            sb.append(c);
            helper(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
