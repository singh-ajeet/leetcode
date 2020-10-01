package org.ajeet.learnings.leetcode.easy.arrays;

import java.util.Arrays;

public final class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0)
            return;

        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        if(matrix[0][0] == 0){
            isFirstRowZero = true;
        }

        for (int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                isFirstColumnZero = true;
            }
            for (int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        isFirstRowZero = true;
                    }
                    if(j == 0) {
                        isFirstColumnZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstRowZero) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isFirstColumnZero) {
            for (int j=0; j< matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 =  {{1,1,1},
                            {1,0,1},
                            {1,1,1}};
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = { {0,1,2,0},
                   {3,4,5,2},
                   {1,3,1,5}};

        setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

    }
}
