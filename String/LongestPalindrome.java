package String;

import java.util.Arrays;

public class LongestPalindrome {

    /**
     * This method is the father*/
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        char[] arr = s.toCharArray();
        int n = arr.length;

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(arr, i, i); // For odd-length palindromes
            int len2 = expandAroundCenter(arr, i, i + 1); // For even-length palindromes
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public int expandAroundCenter(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }

        return right - left - 1; // Length of the palindromic substring
    }
}
