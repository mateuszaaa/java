package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int [] A){
        Set<Integer> complete_set = new HashSet<Integer>();
        Set<Integer> minimal_set = new HashSet<Integer>();
        int counter = 0;
        for (int i:A){
            complete_set.add(i);
        }

        for (int i:A){
            minimal_set.add(i);
            if (minimal_set.equals(complete_set)){
                break;
            }
            counter++;
        }
        return counter;
    }
}

public class Main {

    public static void main(String[] args) {
        int tab[] = {2,2,1,0,1};
        Solution sol = new Solution();
        System.out.println(sol.solution(tab));
    }
}
