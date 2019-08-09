package compareCard;


public class Compare {
    public String compare(Player playerOne,Player playerTwo){
        int playerOneMax = 0;
        int playerTwoMax = 0;
        for(Card item:playerOne.getCards()){
            if(item.getNumber()> playerOneMax){
                playerOneMax = item.getNumber();
            }
        }
        for(Card item:playerTwo.getCards()){
            if(item.getNumber()> playerTwoMax){
                playerTwoMax = item.getNumber();
            }
        }

        if(playerOneMax > playerTwoMax){
            return playerOne.getName();
        }else if(playerOneMax == playerTwoMax){
            return "平手";
        }else {
            return playerTwo.getName();
        }
    }
}
