package com.company;


import java.util.ArrayList;


/**
 * Created by דיקלה on 01/06/2018.
 */
public class Hand {
    private ArrayList<Card> playerCards=new ArrayList<Card>();


    public Hand( ArrayList<Card> cards){
        playerCards.addAll(cards);
    }

    public int getPlayerCardsSize() {
        return playerCards.size();
    }

    public void displayPlayerCards(){
        System.out.println("The cards are:");
        for (Card card : playerCards) {
            System.out.println(card);

        }
        System.out.println("***end of player cards***");
    }

    public Card revealCard(){
        return playerCards.remove(0);
    }

    public void addCard(Card card){
        playerCards.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        playerCards.addAll(cards);

    }





}
