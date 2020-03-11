package com.frog.Ivan.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Rotate string according to number
public class RotateString {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("resources/other/rotatestring.txt");
        BufferedReader br = new BufferedReader(in);
        String s;
        while ((s = br.readLine()) != null) {
            String[] array = s.split(" ");
            int parseInt = Integer.parseInt(array[0]);
            if(parseInt < 0 ) {
                System.out.print(array[1].substring(array[1].length() + parseInt) + array[1].substring(0, array[1].length() + parseInt) + " ");
            } else if (parseInt > 0) {
                System.out.print(array[1].substring(parseInt) + array[1].substring(0,parseInt) + " ");
            } else {
                System.out.println("Something went wrong ");
            }
        }
    }

}
