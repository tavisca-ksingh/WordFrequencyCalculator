package com.wordcounter;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static Map<String,Integer> wordCount = new TreeMap<String,Integer>();
    public static  Set<String> hash_Set = new TreeSet<>();
    public static BufferedReader fileRead() throws IOException{
        File file = new File("File.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return  br;
    }
    public static void main(String[] args) throws IOException {
        String line;
        String [] words=null;
        BufferedReader br= fileRead();
        createSet(br);
        //System.out.println(hash_Set);
        for(String values : hash_Set){
        countWord(values);
          }
    }
    private static void createSet( BufferedReader br) throws IOException {
        String line;
        String[] words;
        while((line = br.readLine()) != null){
            words = line.split(" ");
            for(String word : words )
            {
                if(word.length() >1)
                    hash_Set.add(word);
            }
        }
    }
    public static void countWord(String values) throws IOException{
        String line;
        String[] words;
        BufferedReader br = fileRead();
        int count =0;
        while((line = br.readLine()) != null){
            words = line.split(" ");
            for(int i=0;i<words.length;i++) {
                if (values.equals(words[i])) {
                    count++;
                }
            }
            wordCount.put(values,count);
        }
    }
}
