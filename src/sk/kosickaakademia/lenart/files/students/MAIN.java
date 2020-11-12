package sk.kosickaakademia.lenart.files.students;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class MAIN {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("resources/students.dat");
            String line;


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
