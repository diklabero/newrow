package com.company;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by דיקלה on 01/06/2018.
 */
public class Deck {

    private ArrayList<Card> deck=new ArrayList<Card>();
    private int[] numbers={1,2,3,4,5,6,7,8,9,10,11,12,13};
    private String[] suites={"Hearts","Diamonds","Clubs","Pikes"};


    private ArrayList<Card> getDeck() {
        for (int i = 0; i <suites.length ; i++) {
            for (int j = 0; j <numbers.length ; j++) {
                deck.add(new Card(numbers[j],suites[i]));
                }
        }
        return deck;

    }

    public Deck(){
        getDeck();
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void displayDeck(){
        System.out.println("The cards are:");
        for (Card card : deck) {
            System.out.println(card);

        }
        System.out.println("***end of deck cards***");
    }

    public void shuffleDeck(){
        Random random = new Random();
        for (int i = 0; i <deck.size() ; i++) {
            Card shuffledCard = deck.remove(i);
            deck.add(random.nextInt(deck.size()),shuffledCard);

        }
    }

    public ArrayList<Card> divideDeck(int fromIndex, int toIndex){
        ArrayList<Card> dividedDeck = new ArrayList();
        for (int i = fromIndex; i <toIndex ; i++) {
            dividedDeck.add(deck.get(i));

        }
        return dividedDeck;


    }

}
