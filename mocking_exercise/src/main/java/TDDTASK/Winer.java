package TDDTASK;

import java.util.ArrayList;
import java.util.List;

public class Winer {
    List<PokerCard> pokerCards = new ArrayList<>();

    public Winer(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public Winer() {
    }

    public List<PokerCard> getPokerCards() {
        return pokerCards;
    }

    public void setPokerCards(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }
}
