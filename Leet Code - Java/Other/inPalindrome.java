package Other;

public class inPalindrome {
    public boolean isPalindrome(int n) {

        if (n < 0 || (n != 0 && n % 10 == 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (n > reversedHalf) {
            reversedHalf = reversedHalf * 10 + n % 10;
            n /= 10;
        }

        return n == reversedHalf || n == reversedHalf / 10;
    }
}
