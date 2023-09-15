public class BFS {

    /**
     * "horizontal scanning" or "vertical scanning"
     *
     * This type of problem bases itself on O(n*m),
     * Where n is number of words and m is number of letters in each word
     * */

    /**
     * This method allows us to "iterative prefix reduction"
     * This is most efficient in this scenario as we are on the lookout for prefix,
     * which is often short. This method allows us to reduce m, often immediately*/
    public String longestCommonPrefix(String[] strs) {


        if (strs == null || strs.length == 0) {
            return "";
        }

        //Assume the first string
        String prefix = strs[0];


        //Compare it to the other strings
        for (int i = 1; i < strs.length; i++){

            //While decrease it down by breadth-first search style
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }

        }

        return prefix;
    }


    /**
     * horizontal scanning is less efficient, can be faster to detect outliers(words that don't match.
     * */
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder("");

        String word = strs[0];
        boolean stop = false;


        for(int i = 0; i < word.length(); i++){
            char curr = word.charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != curr){
                    stop = true;
                    break;
                }
            }

            if(stop){
                break;
            }
            sb.append(curr);
        }


        return sb.toString();
    }
}
