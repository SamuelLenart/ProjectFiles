package sk.kosickaakademia.lenart.files;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RWFile {
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
    public void copyAndEncryptFile(String fileName, int offset){
        String name;
        name = getFileName('c');

        BufferedReader reader;
        try {
            if (new File(fileName).exists() == false){
                System.out.println("This file " + fileName + " does not exist!");
                return;
            }
            FileReader fr = new FileReader(fileName);

            File file = new File("resources/" + name);
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            reader = new BufferedReader(fr);
            String line;
            while ((line=reader.readLine()) != null){
                char[] lineChar = new char[line.length()];
                for (int i = 0; i < line.length(); i++){
                    char z = line.charAt(i);
                    if (z >= 'A' && z <= 'Z'){
                        z = (char) (z+offset);
                        if (z > 'Z')
                            z = (char) (z-26);
                    }
                    else if (z >= 'a' && z <= 'z'){
                        z = (char) (z+offset);
                        if (z > 'z')
                            z = (char) (z-26);
                    }
                    else if (z >= '0' && z <= '9'){
                        z = (char) (z+offset);
                        if (z > '9')
                            z = (char) (z-10);
                    }
                    fw.write(z);
                }
                fw.write("\n");
            }

            fr.close();
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
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