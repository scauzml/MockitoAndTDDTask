package TDDTASK;

public enum PrePokerLevelByCodeSize {
    HIGH_CARD_OR_STRAIGHT_OR_FLUSH_OR_STRAIGHT_FLUSH(5),
    PAIR(4),
    TWO_PAIR_OR_THREE_OF_A_KIND(3),
    FULL_HOUSE_OR_FOUR_OF_A_KIND(2);
    int distinctCodeSize;

    PrePokerLevelByCodeSize(int distinctCodeSize) {
        this.distinctCodeSize = distinctCodeSize;
    }

    public int getDistinctCodeSize() {
        return distinctCodeSize;
    }

    public void setDistinctCodeSize(int distinctCodeSize) {
        this.distinctCodeSize = distinctCodeSize;
    }
}
