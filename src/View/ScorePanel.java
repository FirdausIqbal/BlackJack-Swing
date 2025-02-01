package View;


import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int playerScore;
    private int dealerScore;
    private boolean hiddenCard;
    private JLabel score;

    public ScorePanel() {
        setBackground(new Color(231, 231, 231));
        score = new JLabel("Dealer : " + (hiddenCard ? "?" : dealerScore) + " | Player : " + playerScore);
        add(score);
    }

    public void updateScore(int playerScore, int dealerScore, boolean hiddenCard) {
        this.dealerScore = dealerScore;
        this.playerScore = playerScore;
        this.hiddenCard = hiddenCard;
        score.setText("Dealer : " + (!hiddenCard ? "?" : dealerScore) + " | Player : " + playerScore);
    }

}
