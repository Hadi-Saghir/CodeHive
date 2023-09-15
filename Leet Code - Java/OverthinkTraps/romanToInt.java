package OverthinkTraps;

public class romanToInt {

    /**
     * Nothing wrong with hardcoding a switch when appropriate. Alternative methods can
     * display knowledge of datastructure such as HashMap, but you get worse
     * performant code, as it isn't hard coded and runtime increase to insert
     * all the variable and retrieve them.
     *
     * Sure, this code is not flexible but, again, I don't think the Romans will release new
     * numerals any time soon.
     * */
    public int romanToInt(String s) {
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
}
