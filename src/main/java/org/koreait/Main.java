package org.koreait;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1, 2, 3, 4, 5}, 7));
    }
}

class Solution {
    public static int[] solution(int[] sequence, long k) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end   = 0;
        long cur  = 0;
        int answer_st = -1;
        int answer_en = -1;
        for(int i = 0; i < sequence.length; i++){
            end++;
            cur += sequence[i];
            if(cur < k) continue;
            if(cur == k){
                if(min > end - start + 1){
                    min = end - start + 1;
                    answer_st = start;
                    answer_en = end - 1;
                }
            }
            else{
                while(cur > k){
                    cur -= sequence[start++];
                }
                if(cur == k){
                    if(min > end - start + 1){
                        min = end - start + 1;
                        answer_st = start;
                        answer_en = end - 1;
                    }
                }
            }
        }
        return new int []{answer_st, answer_en};
    }
}