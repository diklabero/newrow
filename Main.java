package com.company;

import java.util.ArrayList;

public class Main {

    static Hand player1Hand;
    static Hand player2Hand;
    static ArrayList<Card> warPlayer1 = new ArrayList<Card>();
    static ArrayList<Card> warPlayer2 = new ArrayList<Card>();
    static boolean enoughCards=true;



    public static void main(String[] args) {

        //creating the deck
        Deck deck = new Deck();
        System.out.println("number of cards on the deck: " + deck.getDeckSize());
        deck.displayDeck();
        deck.shuffleDeck();
        // creating players deck/hand
        player1Hand = new Hand(deck.divideDeck(0,26));
        player2Hand = new Hand(deck.divideDeck(26,deck.getDeckSize()));
        System.out.println("number of player1 cards: " + player1Hand.getPlayerCardsSize());
        player1Hand.displayPlayerCards();
        System.out.println("number of player2 cards: " + player2Hand.getPlayerCardsSize());
        player2Hand.displayPlayerCards();
        //starting the game
        System.out.println("LET'S PLAY WAR");
        while (enoughCards){
            //revealing cards for the round:
            System.out.println("The cards for this round are:");
            Card cardPlayer1 = player1Hand.revealCard();
            Card cardPlayer2 = player2Hand.revealCard();
            System.out.println("player1 card is " +cardPlayer1.toString());
            System.out.println("player2 card is " +cardPlayer2.toString());
            //comparing the cards value
            compareCards(cardPlayer1,cardPlayer2);
            //checking rather a player runs out of cards
            if (player1Hand.getPlayerCardsSize()==0||player2Hand.getPlayerCardsSize()==0){
                determineTheWinner();
                //displayCardsCount();
                endGame();
            }
         }


        }



    public static void compareCards(Card cardPlayer1,Card cardPlayer2) {
        if (cardPlayer1.getValue() > cardPlayer2.getValue()) {
            player1Hand.addCard(cardPlayer1);
            player1Hand.addCard(cardPlayer2);
            System.out.println("***player1 wins this round***");
            displayCardsCount();
        } else if (cardPlayer2.getValue() > cardPlayer1.getValue()) {
            player2Hand.addCard(cardPlayer1);
            player2Hand.addCard(cardPlayer2);
            System.out.println("***player2 wins this round***");
            displayCardsCount();
        } else {
            System.out.println("a war is started:");
            warPlayer1.add(cardPlayer1);
            warPlayer2.add(cardPlayer2);
            warCards();
        }
    }

    public static void warCards(){
        if (player1Hand.getPlayerCardsSize()>2&&player2Hand.getPlayerCardsSize()>2){
            for (int i = 0; i <3 ; i++) {
                warPlayer1.add(player1Hand.revealCard());
                warPlayer2.add(player2Hand.revealCard());
                }
            int battelCardIndex = warPlayer1.size()-1;
            System.out.println("The battle cards are:");
            System.out.println("player1 card is " + warPlayer1.get(battelCardIndex).toString());
            System.out.println("player2 card is " + warPlayer2.get(battelCardIndex).toString());
            if (warPlayer1.get(battelCardIndex).getValue() > warPlayer2.get(battelCardIndex).getValue()){
                player1Hand.addCards(warPlayer1);
                player1Hand.addCards(warPlayer2);
                System.out.println("***player1 wins this battle***");
                displayCardsCount();
            }else if (warPlayer2.get(battelCardIndex).getValue() > warPlayer1.get(battelCardIndex).getValue()){
                player2Hand.addCards(warPlayer1);
                player2Hand.addCards(warPlayer2);
                System.out.println("***player2 wins this battle***");
                displayCardsCount();
            }else {
                System.out.println("the war continues");
                warCards();
            }
            warPlayer1.clear();
            warPlayer2.clear();
        }else {
            System.out.println("the war is stopped, there are not enough cards for a war.");
            determineTheWinner();
            endGame();

    }


}
    public static void displayCardsCount(){
        System.out.println("updated cards number after this round:");
        System.out.println("cards number of player1: " + player1Hand.getPlayerCardsSize());
        System.out.println("cards number of player2: " + player2Hand.getPlayerCardsSize());
    }

    public static void endGame(){
        System.out.println("game is over");
        enoughCards=false;

    }

    public static void determineTheWinner (){
        if (player1Hand.getPlayerCardsSize()>player2Hand.getPlayerCardsSize()){
            System.out.println("***PLAYER1 IS THE WINNER OF THE GAME!!!***");
        }else {
            System.out.println("***PLAYER2 IS THE WINNER OF THE GAME!!!***");
        }

    }





}
