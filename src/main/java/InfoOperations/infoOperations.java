package InfoOperations;

import FileService.fileService;

import java.util.ArrayList;

public class infoOperations {

    private final String path;
    private final ArrayList<String> info;

    public infoOperations(String path,ArrayList<String> info){
        this.path=path;
        this.info=info;
    }
    public void codeInfo(int key){
            CipherDecipher infOper = new CipherDecipher(path,info);
            ArrayList<String> res = infOper.code(key);
            fileService fileOper = new fileService(path);
            fileOper.fileWrite(res," [CRYPTED]");
    }

    public void DecodeInfo(int key){
        CipherDecipher infOper = new CipherDecipher(path,info);
        ArrayList<String> res = infOper.deCode(key);
        fileService fileOper = new fileService(path);
        fileOper.fileWrite(res," [DECRYPTED]");
    }
}
