package com.frog.Ivan.cipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaesarShiftCipher {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/cipher/caesarshiftcipher.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        int shift = Integer.parseInt(br.readLine());
        while ((s = br.readLine()) != null) {
            String[] array = s.split("");
            String[] result = new String[s.split("").length];
            for (int i = 0; i < array.length; i++) {
                String a = array[i];
                if (a.equals(".") || a.equals(" ")) {
                    result[i] = a;
                } else {
                    char c;
                    if(a.charAt(0) - shift < 65){
                        c = (char) (90 + (a.charAt(0) - 64) - shift);
                    } else {
                        c = (char) (a.charAt(0) - shift);}
                    result[i] = String.valueOf(c);
                }
                System.out.print(result[i]);
            }
            System.out.print(" ");
        }
    }

}
