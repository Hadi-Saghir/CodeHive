package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

    /**
     * while both HashMap and HashSet exhibit similar average-case runtime complexity,
     * HashMap has a higher storage complexity due to its key-value pair structure.
     * HashSet, on the other hand, has a slightly lower storage complexity since it only stores
     * unique elements without additional associates values.
     *
     *
     * summary: hashmap better runtime, worse memory
     * */

    public int lengthOfLongestSubstringSet(String s) {
        HashSet<Character> set = new HashSet();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                // Update the left pointer to skip repeated characters
                left = Math.max(left, map.get(currentChar) + 1);
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
