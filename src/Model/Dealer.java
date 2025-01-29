package Model;

public class Dealer extends Unit{
    private Card hiddenCard;

    public Dealer(Card hiddenCard) {
        this.hiddenCard = hiddenCard;
    }

    public Card getHiddenCard() {
        return hiddenCard;
    }

    @Override
    public void updateData(Card card) {
        setSum(card.getValue() + getHiddenCard().getValue());
        setAceCount(card.isAce() ? 1 : 0);
    }
}
