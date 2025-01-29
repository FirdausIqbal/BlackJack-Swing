package Model;

public class Player extends Unit{
    @Override
    public void updateData(Card card) {
        setSum(card.getValue());
        setAceCount(card.isAce() ? 1 : 0);
    }
}
