package sk.kosickaakademia.lenart.files.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Student[] array=null;
        array = readStudentsFromFile(array);
        printAllStudents(array);
        printAllWomen(array);
        printAllMen(array);
        try {
            FileReader fr = new FileReader("resources/students.dat");
            String line;
            BufferedReader bf = new BufferedReader(fr);
            line = bf.readLine();
            int num = Integer.parseInt(line);
            System.out.println("File contains " + num + " recirds");
            Student[] array = new Student[num];
            for (int i = 0; i < num; i++) {
                line = bf.readLine();
                String[] temp = line.split(" ");
                double height = Double.parseDouble(temp[3]);
                int weight = Integer.parseInt(temp[4]);
                Student s = new Student(temp[0], temp[1], temp[2], height, weight);
                array[i] = s;
            }
            printAllStudents(array);
            printAllWomen(array);
            printAllMen(array);


            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void printAllStudents(Student[] array) {
        System.out.println("List of all students: ");

        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.println(array[i].getFirstName() + " " + array[i].getLastName() + " " + array[i].getHeight() + " " + array[i].getWeight());
        }
    }

    public static void printAllWomen(Student[] array) {
        System.out.println("Women: ");

        for (Student temp : array) {
            if (temp.getGender() == Gender.FEMALE)
                System.out.println(temp.getFirstName() + " " + temp.getLastName());
        }
    }

    public static void printAllMen(Student[] array) {
        System.out.println("Men: ");

        for (Student temp : array) {
            if (temp.getGender() == Gender.MALE)
                System.out.println(temp.getFirstName() + " " + temp.getLastName());
        }
    }

    public static void printAllAge(Student[] array) {
        System.out.println("\033[31mAge of all students: \033[0m");
        for (Student student : array) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + student.getAge());
        }
        System.out.println();
    }
}
