package View;

import Model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private List<Card> dealerHand;
    private List<Card> playerHand;
    private Card hiddenCard;
    private boolean showHiddenCard;
    public GamePanel() {
        setBackground(new Color(53, 101, 77));
    }

    public void updateUiData(List<Card> dealerHand, List<Card> playerHand, Card hiddenCard, boolean showHiddenCard) {
        this.dealerHand = dealerHand;
        this.playerHand = playerHand;
        this.hiddenCard = hiddenCard;
        this.showHiddenCard = showHiddenCard;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            if(hiddenCard != null) {
                Image hiddenCardImg = new ImageIcon(getClass().getResource(showHiddenCard ?  hiddenCard.getImagePath() : "../Images/BACK.png")).getImage();
                g.drawImage(hiddenCardImg, 20, 20, 110, 154, null);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
