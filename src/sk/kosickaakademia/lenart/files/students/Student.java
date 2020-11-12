package sk.kosickaakademia.lenart.files.students;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int age;
    private double height;
    private int weight;
    public Contact contact;

    public Student(String firstName, String lastName, String id, double height, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.height=height;
        this.weight=weight;
        contact = null;
        setAge();
    }

    private void setAge() {
        DateFormat y = new SimpleDateFormat("yyyy");
        DateFormat m = new SimpleDateFormat("MM");
        DateFormat d = new SimpleDateFormat("dd");
        Date today = new Date();
        int todayYear = Integer.parseInt(y.format(today));
        int todayMonth = Integer.parseInt(m.format(today));
        int todayDay = Integer.parseInt(d.format(today));
        int year;
        int idYear = Integer.parseInt(id.substring(0, 2));
        if (idYear < 20) {
            year = 2000 + idYear;
        }
        else{
            year = 1900 + idYear;
        }
        int idMonth = Integer.parseInt(id.substring(2,4));
        if (idMonth > 50){
            idMonth -= 50;
        }
        int idDay = Integer.parseInt(id.substring(4,6));
        if (todayMonth < idMonth)
            age = todayYear - year - 1;
        else if (todayMonth > idMonth)
            age = todayYear - year;
        else
        if (todayDay <= idDay)
            age = todayYear - year - 1;
        else
            age = todayYear - year;

    }

    public Gender getGender(){
        return id.charAt(2)<'2' ? Gender.MALE:Gender.FEMALE;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
