package com.DmytroShot.InfoOperations;

import com.DmytroShot.FileService.fileService;

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

    public void deCodeInfo(int key){
        CipherDecipher infOper = new CipherDecipher(path,info);
        ArrayList<String> res = infOper.deCode(key);
        fileService fileOper = new fileService(path);
        fileOper.fileWrite(res," [DECRYPTED]");
    }

    public void bruteForceInfo(){
        bruteForcer forceOperation = new bruteForcer(info);
        int key = forceOperation.bruteForce();
        CipherDecipher infOperation = new CipherDecipher(path,info);
        ArrayList<String> res = infOperation.deCode(key);
        fileService fileOperation = new fileService(path);
        fileOperation.fileWrite(res," [BRUTE_FORCED]");
    }
}
