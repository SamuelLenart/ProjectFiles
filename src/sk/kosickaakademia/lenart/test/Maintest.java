package sk.kosickaakademia.lenart.test;

import sk.kosickaakademia.lenart.files.RWFile;

public class Maintest {
    public static void main(String[] args) {
        sk.kosickaakademia.lenart.files.RWFile rwFile = new RWFile();
        rwFile.copyFileWithCapital("resources/text.txt");
    }
}