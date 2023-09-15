package Other;

import java.util.*;

public class letterCombination {

    /**
     * Using a linked-list and stringbuilder decreased runtime
     * from 5ms to 1ms*/
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty()) return new ArrayList<>();


        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new LinkedList<>();
        list.add("");

        for (int i = 0; i < digits.length(); i++) {
            String temp = map.get(digits.charAt(i));

            List<String> tempList = new LinkedList<>();
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                for (String str : list) {
                    tempList.add(new StringBuilder(str).append(ch).toString());
                }
            }
            list = tempList;
        }

        return list;
    }
}
