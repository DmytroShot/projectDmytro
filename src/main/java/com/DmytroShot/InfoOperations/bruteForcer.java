package com.DmytroShot.InfoOperations;

import java.awt.*;
import java.util.*;

import static com.DmytroShot.Constants.Alfabets.ALF_EN;

public class bruteForcer {
    private ArrayList<String> info;

    bruteForcer(ArrayList<String> info){
        this.info=info;
    }

    int bruteForce(){
        HashMap<Character,Integer> lettersCount = new HashMap<>();
        int mostLetterCount=0;
        int resultKey=0;
        for (String row : info){
            pullMap(row,lettersCount);

            for (Map.Entry<Character, Integer> pair:lettersCount.entrySet()){
                if(pair.getValue()>mostLetterCount){
                    mostLetterCount=pair.getValue();
                    resultKey = ALF_EN.indexOf('e')-ALF_EN.indexOf(pair.getKey());
                }
            }
        }

        if(resultKey>0)resultKey-=26;
        return resultKey*-1;
    }

    private static void pullMap(String row,HashMap<Character,Integer> lettersCount){
        for (char letter : row.toCharArray()){
            if (ALF_EN.contains(letter)){
                if (lettersCount.containsKey(letter)){
                    lettersCount.put(letter,lettersCount.get(letter)+1);
                }else {
                    lettersCount.put(letter,1);
                }
            }
        }
    }
}
