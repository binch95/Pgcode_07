package org.koreait;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}}, 0, 1));
    }
}

class Solution {
    public static int solution(String[][] board, int h, int w) {

        ArrayList<String> cc = new ArrayList();
        int[] dw = new int[]{0, 1, -1, 0};
        int[] dh = new int[]{1, 0, 0, -1};
        String middle = board[h][w];
        for (int i = 0; i < 4; i++) {
            try {
                cc.add(board[h - dh[i]][w - dw[i]]);
            } catch (NumberFormatException e) {
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        int answer = (int) cc.stream().filter(e -> e.equals(middle)).count();
        return answer;
    }
}