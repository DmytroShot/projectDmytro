package FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

class fileReader {

    private final String path;
    fileReader(String path){
        this.path=path;
    }
    ArrayList<String> read(){
        ArrayList<String> list=null;
        try{
            list = (ArrayList<String>) Files.readAllLines(Path.of(path));
        }
        catch(IOException e){
            System.out.println(e);
        }
        return list;
    }
}
