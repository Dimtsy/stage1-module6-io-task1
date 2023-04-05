package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try {
            FileInputStream fin = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fin);
            BufferedReader out = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String[][] subStr = new String[out.read()][2];
            int i = 0;
            while ((strLine = out.readLine()) != null) {
                subStr[i] = strLine.split(": ");
                i++;
            }
            in.close();
            return new Profile(subStr[0][1], Integer.parseInt(subStr[1][1]),
                    subStr[2][1], Long.valueOf(subStr[3][1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\Profile.txt");
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(file);
        System.out.println(fileReader.getDataFromFile(file));
    }
}