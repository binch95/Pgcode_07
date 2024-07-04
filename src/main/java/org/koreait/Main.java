package org.koreait;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("2022.05.19",new String[]{"A 6", "B 12", "C 3"},new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
    }
}


class Solution {
    public static ArrayList solution(String today, String[] terms, String[] privacies) {
        ArrayList answer = new ArrayList();
        String[] day = today.split("\\.");
        int dayday = (Integer.parseInt(day[0]) * 28 * 12) + (Integer.parseInt(day[1]) * 28) + Integer.parseInt(day[2]);
        String[] term = null;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < terms.length; i++) {
            term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] newday = privacy[0].split("\\.");
            int proday =Integer.parseInt(String.valueOf(map.get(privacy[1]))) * 28 ;
            int newdayday = (Integer.parseInt(newday[0]) * 28* 12) + Integer.parseInt(newday[1]) * 28 + Integer.parseInt(newday[2]) + proday;
            if (Integer.parseInt(newday[1]) > 12){
                newday[1] = String.valueOf(Integer.parseInt(newday[1]) - 12);
                newday[0] = String.valueOf(Integer.parseInt(newday[0]) + 1);
            }
            if(dayday >= newdayday){
                answer.add(i+1);
            }
        }
        return answer;
    }
}