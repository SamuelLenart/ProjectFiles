package sk.kosickaakademia.lenart.files.students;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int age;

    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        setAge();
    }

    private void setAge() {
        age = 16;
    }

    public Gender getGender(){
        return id.charAt(2)<'2' ? Gender.MALE:Gender.FEMALE;
    }
}
