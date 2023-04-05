package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try (FileInputStream fin = new FileInputStream(file)) {
            String str = "";
            int i;
            while ((i = fin.read()) != -1) {
                str = str + (char) i;
            }
            String[] subStr;
            String delimiter = "\r\n";
            subStr = str.split(delimiter);

            String delimiterTwo = ": ";

            String[] subStrTwo = subStr[0].split(delimiterTwo);
            String name = subStrTwo[1];

            subStrTwo = subStr[1].split(delimiterTwo);
            Integer age = Integer.parseInt(subStrTwo[1]);

            subStrTwo = subStr[2].split(delimiterTwo);
            String email = subStrTwo[1];

            subStrTwo = subStr[3].split(delimiterTwo);
            Long phone = Long.valueOf(subStrTwo[1]);

            return new Profile(name, age, email, phone);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return new Profile();
    }

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\Profile1.txt");
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(file);
    }
}