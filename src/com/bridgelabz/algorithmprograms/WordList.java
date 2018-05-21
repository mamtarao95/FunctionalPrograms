package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordList {

    public static void main(String[] args) throws IOException {
        FileReader fileReader=null;
        try {
             fileReader=new FileReader("/home/administrator/Documents/test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i;
        try {
            while((i=fileReader.read())!=-1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utility.searchWord();
    }

}

