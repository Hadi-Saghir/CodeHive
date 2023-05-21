package String;

public class ZigZag {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        char[] result = new char[s.length()];
        int index = 0;
        int step = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                result[index++] = s.charAt(j);

                if (i != 0 && i != numRows - 1) {
                    int diagonal = j + step - 2 * i;

                    if (diagonal < s.length()) {
                        result[index++] = s.charAt(diagonal);
                    }
                }
            }
        }

        return new String(result);
    }
}
