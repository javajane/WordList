package com.MiscellaneousProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<WordList> wordList = new ArrayList<>();
        ArrayList<String> simplywords = new ArrayList<>();

        String currentLine;
        String infilepath="C:\\Temp\\inputtext.txt";
        String outfilepath="C:\\Temp\\outputtext.txt";
        String[] wordsarray;
        BufferedReader br = new BufferedReader(new FileReader(infilepath));

        while((currentLine=br.readLine()) != null) {
            //System.out.println(currentLine);
            wordsarray=currentLine.split("\\s+");
            for(String word:wordsarray){
                //System.out.println("WORD: " + word);

                String replacedword=word.replaceAll("^\\W*(\\w*)\\W*$", "$1");

                simplywords.add(replacedword);

                //System.out.println("REPLACED WORD: " + replacedword);
                WordList objword = new WordList(replacedword);

                if(wordList.contains(objword)) {
                    int index=wordList.indexOf(objword);
                    wordList.get(index).setTimes();
                }
                else {
                    wordList.add(objword);
                }
            }


        }

        Collections.sort(wordList);
        PrintWriter writer = new PrintWriter(outfilepath);
        for (int i=0; i<wordList.size(); i++) {
            System.out.println("WORD: " + wordList.get(i).getName()
                    + " OCCURRED "
                    + wordList.get(i).getTimes());
            writer.println("WORD: " + wordList.get(i).getName()
                    + " OCCURRED "
                    + wordList.get(i).getTimes());
        }

        writer.println("**************************************************************************");


        for (int i=0; i<simplywords.size(); i++) {
            writer.println("WORD: " + simplywords.get(i));
        }


        writer.close();

    }
}
