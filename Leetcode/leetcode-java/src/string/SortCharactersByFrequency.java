package string;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;


// 451. Sort Characters By Frequency
// Medium

// 1725

// 127

// Add to List

// Share
// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
// Accepted
// 205,362
// Submissions
// 325,397

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        q.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char curr = q.poll();
            for(int i = 0; i < map.get(curr); i++) {
                sb.append(curr);
            }
        }
        return sb.toString();
        
    }
}