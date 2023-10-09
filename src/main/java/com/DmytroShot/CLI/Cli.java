package com.DmytroShot.CLI;

import com.DmytroShot.FileService.fileService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Cli {

    public void printMenu(){
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
            String filePath = scan.nextLine();
            if (!Files.exists(Path.of(filePath))){
                throw new RuntimeException("You write wrong path");
            }

            System.out.println("Write key");
            int key = scan.nextInt();
            if (key<=0){
                throw new RuntimeException("You write wrong key");
            }

            fileService reader = new fileService(filePath);
            CliAction cliAct = new CliAction(command,filePath,key);
            cliAct.cliUse(reader.fileRead());
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }
}
