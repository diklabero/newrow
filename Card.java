package com.company;

/**
 * Created by דיקלה on 01/06/2018.
 */
public class Card {

    private int value;
    private String suite;

    public Card(int value, String suite) {
        this.value = value;
        this.suite = suite;
    }


    public void displayCard(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suite='" + suite + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }


}
