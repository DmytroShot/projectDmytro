package InfoOperations;

import java.util.ArrayList;

import static Constants.Alfabets.ALF_EN;

class CipherDecipher {

    private final String path;
    private final ArrayList<String> info;

    public CipherDecipher(String path,ArrayList<String> info){
        this.path=path;
        this.info=info;
    }
    ArrayList<String> code(int key){
        ArrayList<String> res=new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        for (String row :info){
            for (char letter :row.toCharArray()){
                if (ALF_EN.contains(letter)){
                    strBuilder.append(ALF_EN.get((ALF_EN.indexOf(letter)+key)%26));
                } else if (ALF_EN.contains(Character.toLowerCase(letter))) {
                    strBuilder.append(Character.toUpperCase(getCharByKey(Character.toLowerCase(letter),key)));
                }else {strBuilder.append(letter);}

            }
            res.add(strBuilder.toString());
            strBuilder.delete(0,strBuilder.length());
        }

        return res;
    }

    ArrayList<String> deCode(int key){
        ArrayList<String> res=new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        for (String row :info){
            for (char letter :row.toCharArray()){
                if (ALF_EN.contains(letter)){
                    strBuilder.append(getCharByKey(letter,-key+26));
                } else if (ALF_EN.contains(Character.toLowerCase(letter))) {
                    strBuilder.append(Character.toUpperCase(getCharByKey(Character.toLowerCase(letter),-key+26)));
                }else {strBuilder.append(letter);}

            }
            res.add(strBuilder.toString());
            strBuilder.delete(0,strBuilder.length());
        }

        return res;
    }

    private static char getCharByKey(char letter ,int key){
        return ALF_EN.get((ALF_EN.indexOf(letter)+key)%26);
    }
}
