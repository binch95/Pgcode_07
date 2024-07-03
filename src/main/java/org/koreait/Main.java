package org.koreait;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }
}


class Solution {

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friend = new HashMap<>();
        Map<String, Integer> admin = new HashMap<>();
        List<ff> abc = new ArrayList<>();
        for (String friendName : friends) {
            friend.put(friendName, 0);
            admin.put(friendName, 0);
            for (String friendz : friends) {
                if (!friendz.equals(friendName)) {
                    ff qwe = new ff(friendName, friendz, 0);
                    abc.add(qwe);
                }
            }
        }
        for (String gift : gifts) {
            String[] git = gift.split(" ");
            abc.stream().filter(e -> e.a.equals(git[0]) && e.b.equals(git[1])).collect(Collectors.toList()).get(0).c += 1;

            int answer = friend.get(git[0]);
            friend.put(git[0], answer + 1);
            answer = friend.get(git[1]);
            friend.put(git[1], answer - 1);
        }

        for (String zxc : friends) {
            int a = 0;
            for (int i = 0; i < abc.stream().filter(e -> e.a.equals(zxc)).count(); i++) {
                String s = abc.stream().filter(e -> e.a.equals(zxc)).collect(Collectors.toList()).get(i).b;
                int q = abc.stream().filter(e -> e.a.equals(zxc)).collect(Collectors.toList()).get(i).c;
                int w = abc.stream().filter(e -> e.a.equals(s) && e.b.equals(zxc)).collect(Collectors.toList()).get(0).c;
                if ( q > w){
                    a = a + 1;
                } else if (q == w) {
                    if (friend.get(abc.stream().filter(e -> e.a.equals(zxc)).collect(Collectors.toList()).get(i).a) > friend.get(abc.stream().filter(e -> e.a.equals(s) && e.b.equals(zxc)).collect(Collectors.toList()).get(0).a)){a = a +1;}
                }
            }
            admin.put(zxc, a);
        }

        return admin.values().stream().max(Comparator.naturalOrder()).orElse(0);
    }

    static class ff {
        String a;
        String b;
        int c;

        public ff(String a, String b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }
}