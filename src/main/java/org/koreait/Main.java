package org.koreait;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2));
    }
}

class Solution {
    public static Collection<Integer> solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map1 = new LinkedHashMap<>();
        Set<String> set1 = new LinkedHashSet<>(List.of(report));
        for (String re : id_list) {
            map1.put(re, 0);
            ArrayList<String> xx = new ArrayList<>(Arrays.asList(report).stream().distinct().filter(e -> e.split(" ")[0].equals(re)).collect(Collectors.toList()));
            for (int i = 0; i < xx.size(); i++) {
                String[] q = xx.get(i).split(" ");
                if (Arrays.stream(report).distinct().filter(e -> e.split(" ")[1].equals(q[1])).count() >= k) {
                    map1.put(q[0], map1.get(q[0]) + 1);
                }
            }
        }
        return map1.values();
    }
}