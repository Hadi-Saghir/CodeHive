package String;

import java.util.Arrays;

public class LongestPalindromeTwo {

    /**
     * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String modifiedString = preProcess(s);
        int[] palindromeLengths = new int[modifiedString.length()];

        int center = 0;
        int rightBoundary = 0;
        int maxPalindromeLength = 0;
        int centerIndex = 0;

        for (int i = 1; i < modifiedString.length() - 1; i++) {
            int mirror = 2 * center - i;

            if (rightBoundary > i) {
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }

            while (modifiedString.charAt(i + (1 + palindromeLengths[i])) == modifiedString.charAt(i - (1 + palindromeLengths[i]))) {
                palindromeLengths[i]++;
            }

            if (i + palindromeLengths[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeLengths[i];
            }

            if (palindromeLengths[i] > maxPalindromeLength) {
                maxPalindromeLength = palindromeLengths[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxPalindromeLength) / 2;
        int end = start + maxPalindromeLength;

        return s.substring(start, end);
    }

    private String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');

        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }

        sb.append("#$");
        return sb.toString();
    }
}
