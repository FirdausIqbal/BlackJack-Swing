package Controller;

import Model.Card;
import Model.Dealer;
import Model.Player;
import View.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarEntry;

public class BlackJack {
    private ArrayList<Card> deck;
    private Dealer dealer;
    private Player player;

    private JFrame frame;
    private GamePanel gamePanel;
    private JButton hitButton, stayButton, restart;

    public BlackJack() {
        setupGame();
        setupUI();
    }

    public void setupGame() {
        buildDeck();
        shuffleDeck();
        dealer = new Dealer(pickUp());
        player = new Player();

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

    public void setupUI() {
        frame = new JFrame();
        gamePanel = new GamePanel();
        hitButton = new JButton("Hit");
        stayButton = new JButton("Stay");
        restart = new JButton("Restart");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);
        buttonPanel.add(restart);

        hitButton.addActionListener(e -> hit());
        stayButton.addActionListener(e -> stay());

        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);

        updateUI(false);

    }

    public void hit() {
        player.addCard(pickUp());
        updateUI(false);
        player.reduceAce();
        if(player.getSum() > 21) {
            gameOver("You're Busted!");
        }
    }

    public void stay() {
        updateUI(true);

        while (dealer.getSum() < 17) {
            dealer.addCard(pickUp());
            dealer.reduceAce();
            updateUI(true);
        }

        if (dealer.getSum() > 21) {
            gameOver("Dealer Busted, You Win");
        } else if (dealer.getSum() == player.getSum()) {
            gameOver("Tie!");
        } else if (dealer.getSum() > player.getSum()) {
            gameOver("You Lose!");
        } else if (dealer.getSum() < player.getSum()) {
            gameOver("You Win!");
        }

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
        return deck.removeLast();
    }
    public void updateUI(boolean showHiddenCard) {
        gamePanel.updateUiData(dealer.getHand(), player.getHand(), dealer.getHiddenCard(), showHiddenCard);

    }
    public void gameOver(String message) {
        hitButton.setEnabled(false);
        stayButton.setEnabled(false);
        JOptionPane.showMessageDialog(frame, message);
    }
}
