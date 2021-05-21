package numerals;

import java.util.LinkedHashMap;

public class ArabNum {
    public static Integer arabNumerals(String s) {
        LinkedHashMap<String, Integer> arab_numerals = new LinkedHashMap<String, Integer>();
        arab_numerals.put("X", 10);
        arab_numerals.put("IX", 9);
        arab_numerals.put("VIII", 8);
        arab_numerals.put("VII", 7);
        arab_numerals.put("VI", 6);
        arab_numerals.put("V", 5);
        arab_numerals.put("IV", 4);
        arab_numerals.put("III", 3);
        arab_numerals.put("II", 2);
        arab_numerals.put("I", 1);

        Integer res = 0;
        return arab_numerals.get(s);
    }
}
