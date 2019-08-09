package TDDTASK;

public class PokerCard {
    private int code;
    private String letter;

    public PokerCard(int code, String letter) {
        this.code = code;
        this.letter = letter;
    }

    public PokerCard() {
    }



    public int getCode() {
        return code;
    }

    public String getLetter() {
        return letter;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
