package TDDTASK;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHands {

    public String getWiner(String[] pockerCard1, String[] pockerCard2) {


        Player player1 = createPlayer(pockerCard1);
        Player player2 = createPlayer(pockerCard2);

        List<Integer> player1CardCodeList = player1.getPokerCards().stream().map(e -> {
            return e.getCode();
        }).sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> player2CardCodeList = player2.getPokerCards().stream().map(e -> {
            return e.getCode();
        }).sorted(Integer::compareTo).collect(Collectors.toList());

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
                int equalNum = 2;
                String winer = toFindWinerFromPairOrThreeOfAKind(player1, player2, player1CardCodeList, player2CardCodeList, equalNum);
                if (winer != null) return winer;

            }else if(player1.getPokerLevel()==PokerLevel.TWO_PAIR.getLevel()){

                List<Integer> player1TwoPairCodes = getTwoPairCodes(player1CardCodeList);
                List<Integer> player2TwoPairCodes = getTwoPairCodes(player2CardCodeList);
                if(player1TwoPairCodes.get(1)>player2TwoPairCodes.get(1)){
                        return "win1";
                    }else if(player1TwoPairCodes.get(1)<player2TwoPairCodes.get(1)){
                        return "win2";
                    }else if(player1TwoPairCodes.get(1)==player2TwoPairCodes.get(1)){
                        if(player1TwoPairCodes.get(0) < player2TwoPairCodes.get(0)){
                                    return "win2";
                        } else if (player1TwoPairCodes.get(0) > player2TwoPairCodes.get(0)) {
                            return "win1";
                        }else if (player1TwoPairCodes.get(0) == player2TwoPairCodes.get(0)) {
                            List<Integer> player1Codes0 = getRemainCodeSortedList(player1CardCodeList, player1TwoPairCodes.get(0));
                            List<Integer> player1Codes = getRemainCodeSortedList(player1Codes0, player1TwoPairCodes.get(1));
                            List<Integer> player2Codes0 = getRemainCodeSortedList(player2CardCodeList, player2TwoPairCodes.get(0));
                            List<Integer> player2Codes = getRemainCodeSortedList(player2Codes0, player2TwoPairCodes.get(1));
                             if(player1Codes.get(0)>player2Codes.get(0)){
                                 return "win1";
                             }else if(player1Codes.get(0)<player2Codes.get(0)){
                                 return "win2";
                             }else if(player1Codes.get(0)==player2Codes.get(0)){
                                 return "no win";
                             }

                        }
                    }

            }else if(player1.getPokerLevel()==PokerLevel.THREE_OF_A_KIND.getLevel()){
                int equalNum = 3;
                String winer = toFindWinerFromPairOrThreeOfAKind(player1, player2, player1CardCodeList, player2CardCodeList, equalNum);
                if (winer != null) return winer;

            } else if (player1.getPokerLevel() == PokerLevel.STRAIGHT.getLevel()) {
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
            } else if (player1.getPokerLevel() == PokerLevel.FLUSH.getLevel()) {
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
            }else if(player1.getPokerLevel() == PokerLevel.FULL_HOUSE.getLevel()){
                int equalNum = 3;
                String winer = toFindWinerFromFullHouseOrFourOfAKind(player1, player2,equalNum);
                if (winer != null) return winer;
            } else if (player1.getPokerLevel() == PokerLevel.FOUR_OF_A_KIND.getLevel()) {
                int equalNum = 4;
                String winer = toFindWinerFromFullHouseOrFourOfAKind(player1, player2,equalNum);
                if (winer != null) return winer;
            }else if (player1.getPokerLevel() == PokerLevel.STRAIGHT_FLUSH.getLevel()) {
                int maxCode1 = getMaxCode(player1);
                int maxCode2 = getMaxCode(player2);
                if (maxCode1 > maxCode2) {
                    return "win1";
                } else if(maxCode1<maxCode2){
                    return "win2";
                }else if(maxCode1==maxCode2){
                    return "no win";
                }
            }

        } else if (player1.getPokerLevel() > player2.getPokerLevel()) {
            return "win1";
        } else {
            return "win2";
        }


        return null;
    }

    private List<Integer> getTwoPairCodes(List<Integer> player1CardCodeList) {
        int minPlayerPairCode=getEqualNumByCodeList(player1CardCodeList, 2);
        List<Integer> codeList = getRemainCodeSortedList(player1CardCodeList, minPlayerPairCode);
        int maxPlayerCodePairCode=getEqualNumByCodeList(codeList, 2);
        List<Integer> result = new ArrayList<>();
        result.add(minPlayerPairCode);
        result.add(maxPlayerCodePairCode);
        return result;

    }
    private int getEqualNumByCodeList(List<Integer> codeList, int equalNum) {
        int equalCode = 0;
        for (int i = 0; i < codeList.size(); i++) {
            int count = 0;
            for (int j = 0; j < codeList.size(); j++) {
                if (codeList.get(i) == codeList.get(j)) {
                    count++;
                    if (count == equalNum) {
                        break;
                    }
                }
            }
            if (count == equalNum) {
                equalCode = codeList.get(i);
                break;
            }
        }
        return equalCode;
    }
    private String toFindWinerFromFullHouseOrFourOfAKind(Player player1, Player player2, int equalNum) {
        int equalNum1 = getEqualNum(player1, equalNum);
        int equalNum2 = getEqualNum(player2, equalNum);

        if (equalNum1 > equalNum2) {
            return "win1";
        } else if (equalNum1 < equalNum2) {
            return "win2";
        }
        return null;
    }
    private String toFindWinerFromPairOrThreeOfAKind(Player player1, Player player2, List<Integer> player1CardCodeList, List<Integer> player2CardCodeList, int equalNum) {
        int equalNum1 = getEqualNum(player1, equalNum);
        int equalNum2 = getEqualNum(player2, equalNum);

        if (equalNum1 > equalNum2) {
            return "win1";
        } else if (equalNum1 < equalNum2) {
            return "win2";
        } else if (equalNum1 == equalNum2) {
            String winer = toFindWiner(player1CardCodeList, player2CardCodeList, equalNum1);
            if (winer != null) return winer;
        }
        return null;
    }

    private String toFindWiner(List<Integer> player1CardCodes, List<Integer> player2CardCodes, int equalNum1) {

        List<Integer> player1SortCodeList1=getRemainCodeSortedList(player1CardCodes,equalNum1);
        List<Integer> player2SortCodeList2=getRemainCodeSortedList(player2CardCodes,equalNum1);
        if (player1SortCodeList1.size() > 0) {
            int maxRemainCode1 = player1SortCodeList1.get(player1SortCodeList1.size() - 1);
            int maxRemainCode2 = player2SortCodeList2.get(player2SortCodeList2.size() - 1);

            if(maxRemainCode1>maxRemainCode2){
                return "win1";
            }else if(maxRemainCode1<maxRemainCode2){
                return "win2";
            }else if(maxRemainCode1 == maxRemainCode2){

                return toFindWiner(player1SortCodeList1, player2SortCodeList2, maxRemainCode1);
            }
        }


        return "no win";
    }

    private List<Integer> getRemainCodeSortedList( List<Integer> pokerCardCodeList, int filterCode) {
        return pokerCardCodeList.stream()
                .filter(e -> e != filterCode)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    private int getMaxCode(Player player1) {
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
