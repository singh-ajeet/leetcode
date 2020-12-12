package org.ajeet.algorithms.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Grep {

    public static List<String> grep(String fileName, String keyword, int k) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            LinkedList<String> previousLines = new LinkedList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                previousLines.addLast(line);
                //Customize search accordingly
                if (line.contains(keyword)) {
                    return previousLines;
                } else if(previousLines.size() > k){
                    previousLines.removeFirst();
                }
            }
        } finally{
            if (reader != null) {
                reader.close();
            }
        }
        return Collections.emptyList();
    }

    public static List<String> get(String fileName, List<String> keywords, int before, int after) throws IOException {
        if(fileName == null) {
            throw new IllegalArgumentException("Input file cant be null.");
        }

        List<String> lines = Files.readAllLines(Paths.get(fileName));
        Map<Integer, Boolean> dictionary = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(int i=0; i<lines.size(); i++){
            for (String keyword: keywords){
                findAndAdd(lines, keyword, i, dictionary, result);
                findAndAdd(lines, keyword, i-before, dictionary, result);
                findAndAdd(lines, keyword, i+after, dictionary, result);
            }
        }
        return result;
    }

    private static void findAndAdd(List<String> lines,
                                   String keyword,
                                   int index,
                                   Map<Integer, Boolean> dictionary,
                                   List<String> result){

        if(index >= 0 && index < lines.size()){
            String line = lines.get(index);
            if(line.contains(keyword)){
                if(!dictionary.containsKey(index)){
                    result.add(line);
                }
                dictionary.put(index, true);
            }
        }
    }
}
