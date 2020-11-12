package sk.kosickaakademia.lenart.files.students;

import org.w3c.dom.ls.LSOutput;

public class Contact {
    private String cellphone;
    private String email;
    private String Skype;

    public Contact(){
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return Skype;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        Skype = skype;
    }

    public void print(){
        if (Skype != null)
            System.out.println("Skype: "+Skype);
        if (email != null)
            System.out.println("Email: "+email);
        if (cellphone != null)
            System.out.println("Cellphone: "+cellphone);
    }
}
