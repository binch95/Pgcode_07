package org.koreait;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"a", "b", "c", "d"}, new String[]{"a b", "a b", "c a", "d a", "a b", "c d", "a d", "b c", "b a", "d a"}, 2));
    }
}

class Solution {
    public static Collection<Integer> solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map1 = new LinkedHashMap<>();
        Map<String, Integer> map2 = new LinkedHashMap<>();
        for (String id : id_list){
            map2.put(id, 0);
        }
        for (String re : Arrays.stream(report).distinct().collect(Collectors.toList())) {
            map1.put(re.split(" ")[1], map1.getOrDefault(re.split(" ")[1],0) + 1);
        }

            for (String re : Arrays.stream(report).distinct().collect(Collectors.toList())) {
                if(map1.get(re.split(" ")[1]) >= k){
                map2.put(re.split(" ")[0], map2.get(re.split(" ")[0]) + 1);}
            }
        return map2.values();
    }
}


//class Solution {
//    public static Collection<Integer> solution(String[] id_list, String[] report, int k) {
//        Map<String, Integer> map1 = new LinkedHashMap<>();
//        for (String re : id_list) {
//            map1.put(re, 0);
//            ArrayList<String> xx = new ArrayList<>(Arrays.asList(report).stream().distinct().filter(e -> e.split(" ")[0].equals(re)).collect(Collectors.toList()));
//            for (int i = 0; i < xx.size(); i++) {
//                String[] q = xx.get(i).split(" ");
//                if (Arrays.stream(report).distinct().filter(e -> e.split(" ")[1].equals(q[1])).count() >= k) {
//                    map1.put(q[0], map1.get(q[0]) + 1);
//                }
//            }
//        }
//        return map1.values();
//    }
//}