package sk.kosickaakademia.lenart.test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RWFiletest {
    public void copyFileWithCapital(String fileName) {
        BufferedReader reader;
        try {
            FileReader fr = new FileReader(fileName);

            File file = new File(getFileName('c'));
            file.createNewFile();

            FileWriter fw = new FileWriter(file);

            reader=new BufferedReader(fr);
            String line;
            while((line=reader.readLine())!=null){
                line=line.toUpperCase();
                System.out.println(line);
                fw.write(line+'\n');
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getFileName(char prefix){
        Date today = new Date();
        DateFormat sdf = new SimpleDateFormat("HHmmss");
        String name;
        name = prefix + "_" + sdf.format(today);
        return name;
    }
}