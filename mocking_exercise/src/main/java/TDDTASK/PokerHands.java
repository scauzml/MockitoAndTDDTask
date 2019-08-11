package TDDTASK;

import java.util.List;

public class PokerHands {

    public String getWiner(String[] pockerCard1, String[] pockerCard2) {


        Player player1 = createPlayer(pockerCard1);
        Player player2 = createPlayer(pockerCard2);
        if(player1.getPokerLevel()==player2.getPokerLevel()){
            int maxCode1=player1.getPokerCards().stream().map(e->{
                return e.getCode();
            }).max(Integer::compareTo).get();
            int maxCode2=player2.getPokerCards().stream().map(e->{
                return e.getCode();
            }).max(Integer::compareTo).get();
            if(maxCode1>maxCode2){
                return "win1";
            }else {
                return "win2";
            }
        }

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
