package com.mitrais.training;

import java.io.*;

public class Stream {
    public void fileWriter(String text) {
        FileWriter output=null;
        try{
            output=new FileWriter("output.txt");
            output.write(text);
            output.flush();
            output.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileReader() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("output.txt"));
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }
}
