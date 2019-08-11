package TDDTASK;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<PokerCard> pokerCards = new ArrayList<>();
    private int pokerLevel;
    private int maxCode;


    public Player(List<PokerCard> pokerCards, int pokerLevel) {
        this.pokerCards = pokerCards;
        this.pokerLevel = pokerLevel;
    }

    public Player(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public Player() {
    }

    public Player(List<PokerCard> pokerCards, int pokerLevel, int maxCode) {
        this.pokerCards = pokerCards;
        this.pokerLevel = pokerLevel;
        this.maxCode = maxCode;
    }

    public int getMaxCode() {
        return maxCode;
    }

    public void setMaxCode(int maxCode) {
        this.maxCode = maxCode;
    }

    public int getPokerLevel() {
        return pokerLevel;
    }

    public void setPokerLevel(int pokerLevel) {
        this.pokerLevel = pokerLevel;
    }

    public List<PokerCard> getPokerCards() {
        return pokerCards;
    }

    public void setPokerCards(List<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public void caculatePokerLevel() {

        boolean isStraight=true;
        List<Integer> codeList=this.pokerCards.stream().map(e->{
            return e.getCode();
        }).sorted(Integer::compareTo).collect(Collectors.toList());

        isStraight = isStraight(codeList);

        int distinctCodeSize = this.pokerCards.stream().map(e -> {
            return e.getCode();
        }).collect(Collectors.toSet()).size();

        if (distinctCodeSize == PrePokerLevelByCodeSize
                .HIGH_CARD_OR_STRAIGHT_OR_FLUSH_OR_STRAIGHT_FLUSH
                .getDistinctCodeSize()) {

            int distinctLetterSize = this.pokerCards.stream().map(e -> {
                return e.getLetter();
            }).collect(Collectors.toSet()).size();

            if (distinctLetterSize == LetterSituation.All_SAME.getCode()) {

                if(isStraight){
                    this.pokerLevel=PokerLevel.STRAIGHT_FLUSH.getLevel();
                }else {
                    this.pokerLevel=PokerLevel.FLUSH.getLevel();
                }
            } else {
                if(isStraight){
                    this.pokerLevel=PokerLevel.STRAIGHT.getLevel();
                }else {
                    this.pokerLevel=PokerLevel.HIGH_CARD.getLevel();
                }
            }

        } else if (distinctCodeSize == PrePokerLevelByCodeSize.PAIR.getDistinctCodeSize()) {
            this.pokerLevel = PokerLevel.PAIR.getLevel();
        } else if (distinctCodeSize == PrePokerLevelByCodeSize.TWO_PAIR_OR_THREE_OF_A_KIND.getDistinctCodeSize()) {
            int maxCodeCount = getMaxCodeCount(codeList);
            if(maxCodeCount==2){
                this.pokerLevel=PokerLevel.TWO_PAIR.getLevel();
            }else if(maxCodeCount==3){
                this.pokerLevel=PokerLevel.THREE_OF_A_KIND.getLevel();
            }

        } else if (distinctCodeSize == PrePokerLevelByCodeSize.FULL_HOUSE_OR_FOUR_OF_A_KIND.getDistinctCodeSize()) {
            int maxCodeCount = getMaxCodeCount(codeList);
            if(maxCodeCount==3){
                this.pokerLevel=PokerLevel.FULL_HOUSE.getLevel();
            }else if(maxCodeCount==4){
                this.pokerLevel=PokerLevel.FOUR_OF_A_KIND.getLevel();
            }

        }


    }

    private int getMaxCodeCount(List<Integer> codeList) {
        List<Integer> codeCountList = codeList.stream().map(e -> {
            int count = 0;
            for (int code : codeList
            ) {
                if (code == e) {
                    count++;
                }
            }
            return count;
        }).collect(Collectors.toList());
        return codeCountList.stream().max(Integer::compareTo).get();
    }

    private boolean isStraight(List<Integer> codeList) {
        boolean isStraight=true;
        for (int i = 0; i < codeList.size(); i++) {
            if((codeList.get(i)+1)!=codeList.get(i+1)){
                isStraight=false;
                break;
            }
        }
        return isStraight;
    }
}
