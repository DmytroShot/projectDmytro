package com.DmytroShot.FileService;

import java.util.ArrayList;

public class fileService {
    private final String path;

    public fileService(String path){
        this.path=path;
    }

    public ArrayList<String> fileRead(){
        fileReader reader = new fileReader(path);
        return reader.read();
    }

    public void fileWrite(ArrayList<String> message, String type){
        fileWriter writer=new fileWriter(path,message);
        writer.write(type);
    }
}
