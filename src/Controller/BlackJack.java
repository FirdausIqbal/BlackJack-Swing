package Controller;

import Model.Card;
import Model.Dealer;
import Model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJack {
    private ArrayList<Card> deck;

    public BlackJack() {
        setupGame();
    }

    public void setupGame() {
        buildDeck();
        shuffleDeck();

        Dealer dealer = new Dealer(pickUp());
        Player player = new Player();

        dealer.addCard(pickUp());

        player.addCard(pickUp());
        player.addCard(pickUp());
        System.out.println("Dealer:");
        System.out.println(dealer.getHand());
        System.out.println(dealer.getHiddenCard());
        System.out.println(dealer.getSum());
        System.out.println(dealer.getAceCount());

        System.out.println("Player :");
        System.out.println(player.getHand());
        System.out.println(player.getSum());
        System.out.println(player.getAceCount());

        System.out.println("Deck remaining : " + deck.size());
    }


    public void buildDeck() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "S", "H", "D"};
        deck = new ArrayList<>();
        for (String value : values) {
            for (String type : types) {
                deck.add(new Card(value, type));
            }
        }

    }
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    public Card pickUp() {
        return deck.remove(deck.size() - 1);
    }
}
