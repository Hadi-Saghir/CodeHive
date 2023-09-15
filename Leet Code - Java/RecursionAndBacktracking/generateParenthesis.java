package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {

    /**
     * I found this solution that ingenious It optimized recursion and in this case, improved
     * both runtime and memory.
     * */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] str = new char[2*n];
        generate(str, 0, n, 0, 0, result);
        return result;
    }

    void generate(char str[], int pos, int n, int open, int close, List<String> result) {
        if (close == n) {
            result.add(new String(str));
        } else {
            // try open
            if (open < n) {
                str[pos] = '(';
                generate(str, pos+1, n, open+1, close, result);
            }
            // try close
            if (open > close) {
                str[pos] = ')';
                generate(str, pos+1, n, open, close+1, result);
            }
        }
    }

    /**
     * I implemented a slower backtracking method as this kept on generating new list rather
     * than utilizing optimized insertion. However, this method was more intuitive for me, which implies my lack
     * of familiarity with recursion implementation
     * */
    public List<String> generateParenthesisMine(int n) {


        List<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet();
        list.add("()");
        set.add("()");

        for (int i = 1; i < n; i++) {
            List<String> tempList = new LinkedList<>();

            for (String str : list) {
                for (int j = 0; j < str.length(); j++){
                    String tempStr = new StringBuilder(str).insert(j,"()").toString();
                    if(!set.contains(tempStr)){
                        tempList.add(tempStr);
                        set.add(tempStr);
                    }
                }
            }

            list = tempList;
        }

        return list;
    }
}
