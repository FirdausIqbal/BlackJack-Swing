package Model;

public class Card {
    private String value;
    private String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return value + "-" + type;
    }

    public String getImagePath() {
        return "../Images/" + toString() + ".png";
    }

    public int getValue() {
        if ("JQKA".contains(value)) {
            if (value.equals("A")) {
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(value);
    }

    public boolean isAce() {
        return value.equals("A");
    }
}
