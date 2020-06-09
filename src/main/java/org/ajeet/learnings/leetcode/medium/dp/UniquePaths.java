package org.ajeet.learnings.leetcode.medium.dp;

import java.util.Arrays;

public final class UniquePaths {

    public int uniquePaths_DP(int m, int n) {
        if(m == 0 || n ==0)
            return 0;

        int [][] dp = new int[m][n];
        //Set all cells to 1
        for(int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    private boolean[][] visited;

    public int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        visited = new boolean[m][n];
        return uniquePaths(m, n, 0, 0);
    }

    private int uniquePaths(int m, int n, int i, int j) {
        if(i == m-1 && j == n-1)
            return 1;

        int uniquePaths = 0;

        if(i < m-1 && !visited[i+1][j]) {
            uniquePaths = uniquePaths + uniquePaths(m, n, i+1, j);
        }
        if(j < n-1 && !visited[i][j+1]) {
            uniquePaths = uniquePaths + uniquePaths(m, n, i, j+1);
        }
        return  uniquePaths;
    }

    public static void main(String[] args) {
     //   System.out.println(new UniquePaths().uniquePaths(3, 2));
        System.out.println(new UniquePaths().uniquePaths_DP(3, 2));
    }
}
