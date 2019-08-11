package TDDTASK;

import java.util.List;

public class PokerHands {

    public String getWiner(String[] pockerCard1, String[] pockerCard2) {


        Player Player1 = createPlayer(pockerCard1);
        Player Player2 = createPlayer(pockerCard2);



        return null;
    }

    private Player createPlayer(String[] pockerCards) {

        Player Player = new Player();
        List<PokerCard> pokerCardList = Player.getPokerCards();
        for (String card: pockerCards
        ) {
            int cardNum;
            String[] cards=card.split("");
            String cardNumStr=cards[0];
            String cardLetter=cards[1];
            switch (cardNumStr){
                case "T":cardNum=10;break;
                case "J":cardNum=11;break;
                case "Q":cardNum=12;break;
                case "K":cardNum=13;break;
                case "A":cardNum=14;break;
                default:
                    cardNum = Integer.parseInt(cardNumStr);
            }
            PokerCard pokerCard = new PokerCard();
            pokerCard.setCode(cardNum);
            pokerCard.setLetter(cardLetter);
            pokerCardList.add(pokerCard);
        }
        Player.caculatePokerLevel();
        return Player;
    }

}
