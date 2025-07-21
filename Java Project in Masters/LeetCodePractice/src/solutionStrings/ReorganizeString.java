package solutionStrings;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    public String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            i++;
        }
        System.out.println(map.toString());
        return s;
    }

}
