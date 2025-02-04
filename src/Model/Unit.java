package Model;

import java.util.ArrayList;

public abstract class Unit {
    private ArrayList<Card> hand;
    private int aceCount;
    private int sum;

    public Unit() {
        hand = new ArrayList<>();
        sum = 0;
        aceCount = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        updateData(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    abstract void updateData(Card card);

    public void setSum(int sum) {
        this.sum += sum;
    }

    public void setAceCount(int aceCount) {
        this.aceCount += aceCount;
    }

    public int getAceCount() {
        return aceCount;
    }

    public int getSum() {
        return sum;
    }

    public void reduceAce() {
        if (sum > 21 && aceCount > 0) {
            sum -= (10 * aceCount);
            aceCount -= 1;
        }

    }


}
