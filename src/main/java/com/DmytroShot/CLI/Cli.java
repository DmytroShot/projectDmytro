package com.DmytroShot.CLI;

import com.DmytroShot.FileService.fileService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Cli {

    private final String action;
    private final String filePath;
    private final int key;

    public Cli(String action,String filePath,int key){
        this.action=action;
        this.filePath=filePath;
        this.key=key;
    }
    public Cli(){
        this(null,null,0);
    }

    public void typeOfWork(String type){
        if ("WITHOUT".equals(type)){
            printMenu();
        }else {
            runCliUse(action,filePath,key);
        }
    }
    private void printMenu(){
        Scanner scan =new Scanner(System.in);
        try {
            System.out.println("Write action you wanna do\n"+
                    "[c]rypt\n"+
                    "[d]ecrypt\n"+
                    "[b]rute force");
            String command = scan.nextLine();
            if (!"c".contains(command.toLowerCase())&&!"d".contains(command.toLowerCase())&&!"b".contains(command.toLowerCase())){
                throw new RuntimeException("You write wrong word");
            }

            System.out.println("Write file path");
            String path = scan.nextLine();
            if (!Files.exists(Path.of(path))||!path.endsWith(".txt")){
                throw new RuntimeException("You write wrong path");
            }

            int key = 0;
            if (!"b".equalsIgnoreCase(command)) {
                System.out.println("Write key");
                key = scan.nextInt();
                if (key<=0){
                    throw new RuntimeException("You write wrong key");
                }
            }

            runCliUse(command,path,key);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    private static void runCliUse(String action,String filePath,int key){
        fileService reader = new fileService(filePath);
        CliAction cliAct = new CliAction(action,filePath,key);
        cliAct.cliUse(reader.fileRead());
    }
}
