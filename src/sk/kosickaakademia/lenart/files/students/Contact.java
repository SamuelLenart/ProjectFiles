package sk.kosickaakademia.lenart.files.students;

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
}
