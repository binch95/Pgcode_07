package org.koreait;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}));
    }
}

class Solution {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[name.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int z = 0;
            for (int j = 0; j < photo[i].length; j++) {
                try {
                    z = z + map.get(photo[i][j]);
                }catch (NullPointerException e) {
                    continue;
                }
            }
            if(z != 0) {
                result[i] = z;
            }
        }

        return result;
    }
}