package FileService;

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
            path=path.replace(path.substring(path.lastIndexOf("."),path.length()),type+(path.substring(path.lastIndexOf("."),path.length())));

            Files.write(Path.of(path),message);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
