package HashMap;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

    /**
     * This problem introduces the difference between HashMap and Switch in Java.
     * The HashMap takes more storage and performs worse due to hashing becoming to great of an overhead
     *
     *
     * The HashMap is however dynamic and perform better with larger cases owing to hashing*/
    public int romanToIntSwitch(String s) {
        int ans = 0, num=0 , prev=0;
        for(int i=s.length()-1; i >= 0; i--){
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;

            }
            if (num < prev) {
                ans -= num;
            }

            else{
                ans += num;
            }
            prev = num;
        }
        return ans;
    }

    public int romanToIntHash(String romanNumeral) {

        Map<Character, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentChar = romanNumeral.charAt(i);
            int currentValue = romanToIntegerMap.get(currentChar);

            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
