package com.practice.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String path = "/Users/maleeq125/Downloads/untitled folder/austin_crime.csv";
        String line ="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine() ) != null){

                String [] values = line.split(",");
                System.out.println(values[0]);
                //System.out.println(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

