package org.ajeet.learnings.leetcode.easy.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return Collections.emptyList();

        LinkedList<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Collections.singletonList(1));

        int i = 2;
        while (i <= numRows) {
            List<Integer> previousRow = triangle.getLast();
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);

            for(int j=1; j<previousRow.size(); j++) {
                nextRow.add(previousRow.get(j-1)  + previousRow.get(j));
            }
            nextRow.add(1);
            triangle.addLast(nextRow);
            i++;
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
