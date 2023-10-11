package com.DmytroShot.CLI;

import com.DmytroShot.InfoOperations.infoOperations;

import java.util.ArrayList;

public class CliAction {
    private final String command;
    private final String filePath;
    private final int key;

    CliAction(String command, String filePath, int key){
        this.command = command;
        this.filePath = filePath;
        this.key = key;
    }

    void cliUse(ArrayList<String> info){
        infoOperations writer = new infoOperations(filePath,info);
        switch (command){
            case "ENCRYPT" :
            case "c" : writer.codeInfo(key);
            case "DECRYPT" :
            case "d" : writer.deCodeInfo(key);
            case "BRUTE_FORCE" :
            case "b" : writer.bruteForceInfo();
        }
    }
}
