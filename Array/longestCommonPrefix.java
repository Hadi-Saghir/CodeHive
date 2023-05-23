package Array;

public class longestCommonPrefix {

    /**
     * Remember when searching an array in a two-dimensional way, comparing each
     * word (horizontal) their letters (vertically). Consider both ways and according
     * to the data, choose the best algorithm.
     *
     *
     * */
    public String longestCommonPrefix(String[] strs) {


        if (strs == null || strs.length == 0) {
            return "";
        }

        //Assume the first string
        String prefix = strs[0];


        //Compare it to the other strings
        for (int i = 1; i < strs.length; i++){

            //While decrease it down by breadth-first search type
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }

        }

        return prefix;
    }
}
