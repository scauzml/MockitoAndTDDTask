package TDDTASK;

import java.util.List;
import java.util.stream.Collectors;

public class PokerHands {

    public String getWiner(String[] pockerCard1, String[] pockerCard2) {


        Player player1 = createPlayer(pockerCard1);
        Player player2 = createPlayer(pockerCard2);

        List<Integer> player1CardCodeList = player1.getPokerCards().stream().map(e -> {
            return e.getCode();
        }).collect(Collectors.toList());
        List<Integer> player2CardCodeList = player2.getPokerCards().stream().map(e -> {
            return e.getCode();
        }).collect(Collectors.toList());

        if (player1.getPokerLevel() == player2.getPokerLevel()) {
            if (player1.getPokerLevel() == PokerLevel.HIGH_CARD.getLevel()) {
                int maxCode1 = getMaxCode(player1);
                int maxCode2 = getMaxCode(player2);
                if (maxCode1 > maxCode2) {
                    return "win1";
                } else if(maxCode1<maxCode2){
                    return "win2";
                }else if(maxCode1==maxCode2){
                    String winer = toFindWiner(player1CardCodeList, player2CardCodeList, maxCode1);
                    if (winer != null) return winer;
                }


            } else if (player1.getPokerLevel() == PokerLevel.PAIR.getLevel()) {
                int equalNum1 = getEqualNum(player1, 2);
                int equalNum2 = getEqualNum(player2, 2);

                if (equalNum1 > equalNum2) {
                    return "win1";
                } else if (equalNum1 < equalNum2) {
                    return "win2";
                } else if (equalNum1 == equalNum2) {
                    String winer = toFindWiner(player1CardCodeList, player2CardCodeList, equalNum1);
                    if (winer != null) return winer;
                }

            }

        } else if (player1.getPokerLevel() > player2.getPokerLevel()) {
            return "win1";
        } else {
            return "win2";
        }


        return null;
    }

    private String toFindWiner(List<Integer> player1CardCodeList, List<Integer> player2CardCodeList, int equalNum1) {

        List<Integer> player1SortCodeList=getRemainCodeSortedList(player1CardCodeList,equalNum1);
        List<Integer> player2SortCodeList=getRemainCodeSortedList(player2CardCodeList,equalNum1);

        Integer maxRemainCode1 = player1CardCodeList.get(player1CardCodeList.size() - 1);
        Integer maxRemainCode2 = player2CardCodeList.get(player2CardCodeList.size() - 1);

        if(maxRemainCode1>maxRemainCode2){
            return "win1";
        }else if(maxRemainCode1<maxRemainCode2){
            return "win2";
        }else if(maxRemainCode1==maxRemainCode2){

            return toFindWiner(player1CardCodeList, player2CardCodeList, maxRemainCode1);
        }

        return null;
    }

    private List<Integer> getRemainCodeSortedList( List<Integer> pokerCardCodeList, int filterCode) {
        return pokerCardCodeList.stream()
                .filter(e -> e != filterCode)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    private Integer getMaxCode(Player player1) {
        return player1.getPokerCards().stream()
                .map(e -> {
                    return e.getCode();
                })
                .max(Integer::compareTo).get();
    }

    private int getEqualNum(Player player, int equalNum) {
        int equalCode = 0;
        for (int i = 0; i < player.getPokerCards().size(); i++) {
            int count = 0;
            for (int j = 0; j < player.getPokerCards().size(); j++) {
                if (player.getPokerCards().get(i).getCode() == player.getPokerCards().get(j).getCode()) {
                    count++;
                    if (count == equalNum) {
                        break;
                    }
                }
            }
            if (count == equalNum) {
                equalCode = player.getPokerCards().get(i).getCode();
                break;
            }
        }
        return equalCode;
    }

    private Player createPlayer(String[] pockerCards) {

        Player Player = new Player();
        List<PokerCard> pokerCardList = Player.getPokerCards();
        for (String card : pockerCards
        ) {
            int cardNum;
            String[] cards = card.split("");
            String cardNumStr = cards[0];
            String cardLetter = cards[1];
            switch (cardNumStr) {
                case "T":
                    cardNum = 10;
                    break;
                case "J":
                    cardNum = 11;
                    break;
                case "Q":
                    cardNum = 12;
                    break;
                case "K":
                    cardNum = 13;
                    break;
                case "A":
                    cardNum = 14;
                    break;
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
