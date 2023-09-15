package Other;

public class isMatch {

    /**
     * My initial attempt which was abandoned. I hoped for a more performant algorithem
     * by avoiding creating and insertion O(N+M) in addition to comparison O(N*M)*/
    public boolean isMatch(String s, String p) {

        if(s== null || s.isEmpty()) return false;

        int counterS = 0;
        int counterP = 0;

        char currS = s.charAt(counterS);
        char currP = p.charAt(counterP);


        while(counterP < p.length() - 1 && counterS < s.length() - 1){


            currS = s.charAt(++counterS);
            currP = p.charAt(++counterP);


            while(counterP < p.length() + 1 && p.charAt(counterP + 1) == '*' && counterS < s.length() - 1){
                if( currP != '.' && currS != s.charAt(counterS)){
                    break;
                }
                counterS++;
            }

            if(currP == '.'){
                continue;
            }
        }

        counterS--;

        return counterS == s.length() - 1;

    }

    /**
     * Memoization can improve the performance of recursive algorithms,
     * including regular expression matching, by avoiding redundant computations*/

    public boolean isMatchMemo(String s, String p) {

        int rows = s.length();
        int columns = p.length();

        if (rows == 0 && columns == 0) {
            return true;
        }
        if (columns == 0) {
            return false;
        }

        boolean[][] dp = new boolean[rows + 1][columns + 1];

        dp[0][0] = true;

        for (int i = 2; i < columns + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }
            }
        }
        return dp[rows][columns];
    }
}
