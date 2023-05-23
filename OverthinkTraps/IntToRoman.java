package OverthinkTraps;

public class IntToRoman {

    /**
     * Nothing wrong with hardcoding an array when appropriate. Alternative methods can
     * display ability to code mathematical logic, but this is too showy and
     * your most likely to do more wrong, overthink and get worse performant code.
     *
     * Sure, this code is not flexible but I don't think the Romans will release new
     * numerals any time soon.
     * */
    final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int N) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i];
            }
        return ans.toString();
    }

}
