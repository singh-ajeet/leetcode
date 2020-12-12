package org.ajeet.learnings.leetcode.easy.strings;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    private static boolean _wordBreak2(String s, List<String> wordDict, int start, Boolean[] mem) {
        if(start == s.length())
            return true;

        if(mem[start] != null)
            return mem[start];

        for(int i=start+1; i<=s.length(); i++){
            if(wordDict.contains(s.substring(start, i)) && _wordBreak2(s, wordDict, i, mem)){
                mem[i] = true;
                return true;
            }
        }
        return mem[start] = false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] mem = new Boolean[s.length()];
        return _wordBreak2(s, wordDict, 0, mem);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;

        for(int i=1; i<s.length(); i++){
            boolean left = wordDict.contains(s.substring(0, i));
            boolean right = wordBreak(s.substring(i, s.length()), wordDict);
            if(left && right)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
