package org.ajeet.learnings.leetcode.easy.searching;

public final class FirstBadVersion {

    public static int firstBadVersion(int version) {
        int start = 1;
        int end = version;

        int firstBadVersion = version;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int version) {
        if(version < 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }
}
