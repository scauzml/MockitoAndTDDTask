package TDDTASK;

import java.util.ArrayList;
import java.util.List;

public class Winer {
    List<PokerCard> pokerCards = new ArrayList<>();
    private  String pokerType;

    public String getPokerType() {
        return pokerType;
    }

    public void setPokerType(String pokerType) {
        this.pokerType = pokerType;
    }

    public Winer(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public Winer() {
    }

    public Winer(List<PokerCard> pokerCards, String pokerType) {
        this.pokerCards = pokerCards;
        this.pokerType = pokerType;
    }

    public List<PokerCard> getPokerCards() {
        return pokerCards;
    }

    public void setPokerCards(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }
}
