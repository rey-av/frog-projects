package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TODO: in progress
public class FourPicsOneWord {

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("resources/other/fourpicsoneword.txt");
        BufferedReader br = new BufferedReader(in);
        String s;

        FileReader dicIn = new FileReader("resources/misc/dictionary.txt");
        BufferedReader dicBr = new BufferedReader(dicIn);
        String dicS;

        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            while ((dicS = br.readLine()) != null) {
//                if(dicS.chars().filter(value -> {
//                    return ;
//                }));
            }
        }

    }
}
