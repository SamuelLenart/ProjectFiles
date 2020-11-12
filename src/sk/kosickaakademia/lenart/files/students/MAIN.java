package sk.kosickaakademia.lenart.files.students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MAIN {
    public static void main(String[] args) {
        Student[] array = null;
        array = readStudentsFromFile(array);
        array = readContactsFromFile(array);
        printAllStudents(array);
        printAllWomen(array);
        printAllMen(array);
    }

    private static Student[] readContactsFromFile(Student[] array){
        try {
            if (!new File("resources/contacts.dat").exists()){
                System.out.println("This file does not exist!");
            }
            FileReader fr = new FileReader("resources/contacts.dat");
            String line;
            BufferedReader reader = new BufferedReader(fr);
            String email = null;
            String mobil = null;
            String skype = null;
            while ((line= reader.readLine()) != null){
                String[] temp = line.split(" ");
                for (Student student : array) {
                    Contact contact = new Contact();
                    if (temp[0].equals(student.getFirstName()) && temp[1].equals(student.getLastName())) {
                        for (int i = 2; i < temp.length; i++) {
                            String temp1 = temp[i];
                            switch (temp1.substring(0, 5)) {
                                case "email" -> email = temp1.substring(6);
                                case "mobil" -> mobil = temp1.substring(6);
                                case "skype" -> skype = temp1.substring(6);
                            }
                        }
                        if (email != null)
                            contact.setEmail(email);
                        if (skype != null)
                            contact.setSkype(skype);
                        if (mobil != null)
                            contact.setCellphone(mobil);
                        student.setContact(contact);
                        break;
                    }

                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return array;
    }

    private static Student[] readStudentsFromFile(Student[] array) {
        try {
            FileReader fr = new FileReader("resources/students.dat");
            String line;
            BufferedReader bf = new BufferedReader(fr);
            line = bf.readLine();
            int num = Integer.parseInt(line);
            System.out.println("File contains " + num + " records");
            array = new Student[num];
            for (int i = 0; i < num; i++) {
                line = bf.readLine();
                String[] temp = line.split(" ");
                double height = Double.parseDouble(temp[3]);
                int weight = Integer.parseInt(temp[4]);
                Student s = new Student(temp[0], temp[1], temp[2], height, weight);
                array[i] = s;
            }


            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return array;
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
        System.out.println("Age of all students: ");
        for (Student student : array) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + student.getAge());
        }
        System.out.println();
    }
}
