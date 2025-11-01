package se.sprinto.hakan.adventuregame.view;

import java.util.Scanner;

public class FakeUI implements UI{

    private String input;
    private Scanner scanner = new Scanner(System.in);

    public void setInput (String input) {
        this.input = input;
    }

    public String getInput(String prompt){
        System.out.println(prompt);
        return input;
    }

    public void showMessage( String message) {

    }

}
