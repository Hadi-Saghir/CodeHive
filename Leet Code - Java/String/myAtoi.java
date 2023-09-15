package String;

public class myAtoi {
    public int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int counter = 0;

        // Step 1 - Read in and ignore any leading whitespace.
        while (counter < s.length() && s.charAt(counter) == ' ') {
            counter++;
        }

        // Step 2 - Determine the sign.
        int sign = 1;
        if (counter < s.length() && s.charAt(counter) == '+') {
            counter++;
        } else if (counter < s.length() && s.charAt(counter) == '-') {
            sign = -1;
            counter++;
        }

        // Step 3 - Read in the number.
        long num = 0;
        if (counter < s.length()) {
            while (counter < s.length() && Character.isDigit(s.charAt(counter))) {
                int digit = Character.getNumericValue(s.charAt(counter));
                num = num * 10 + digit;

                if (++counter >= s.length() || num >= (long) Integer.MAX_VALUE + 1) {
                    break;
                }
            }
        }

        if (num >= Integer.MAX_VALUE) {
            if (sign == -1 && num >= (long) Integer.MAX_VALUE + 1) {
                num = -(long) Integer.MIN_VALUE;
            } else {
                num = Integer.MAX_VALUE;
            }
        }

        return (int) num * sign;

    }


    public int myAtoiTwo(String s) {
        if (s == null || s.isEmpty()) {
            return 0; // or handle the empty string case as needed
        }
        int len = s.length();
        double num = 0;
        int i = 0;
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        if(i > len - 1) return 0;
        boolean positive = s.charAt(i) == '+';
        boolean negative = s.charAt(i) == '-';
        if (positive || negative) {
            ++i;
        }
        int max=Integer.MAX_VALUE / 10;
        int res = 0;
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int digit = s.charAt(i)-'0';
            if(res > max || (res == max && digit > 7)){
                return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            res = (res * 10) + digit;
            i++;
        }
        return negative ? -res : res;
    }
}
