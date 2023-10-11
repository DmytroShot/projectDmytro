package com.DmytroShot.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

class fileWriter {
    private String path;
    private final ArrayList<String> message;
    fileWriter(String path, ArrayList<String> message){
        this.path=path;
        this.message=message;
    }
    void write(String type){

        try{

            String pathEnds = path.substring(path.lastIndexOf("\\"),path.lastIndexOf("."));
            String pathEnds2=pathEnds;
            if (pathEnds.contains("[CRYPTED]")){
                pathEnds2=pathEnds.replace(" [CRYPTED]","");
            } else if (pathEnds.contains("[DECRYPTED]")) {
                pathEnds2=pathEnds.replace(" [DECRYPTED]","");
            }
                path=path.replace(pathEnds,pathEnds2+type);


            Files.write(Path.of(path),message);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
