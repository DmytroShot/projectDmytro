package com.DmytroShot.Runner;

import com.DmytroShot.CLI.Cli;

public class Main {
        public static void main(String[] args) {
                if (args.length==0){
                        Cli menu = new Cli();
                        menu.typeOfWork("WITHOUT");
                } else if (args.length==2||args.length==3) {
                        Cli menu = new Cli(args[0],args[1],Integer.parseInt(args[2]));
                }
                else {
                        throw new RuntimeException("Args parametrs length is wrong");
                }

        }
}
