package compareCard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompareCardTest {

    @Test
    public void should_return_winner_is_PlayerOne(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card(5,"5H");
        Card card2 = new Card(6,"6H");
        Card card3 = new Card(8,"8C");
        Card card4 = new Card(9,"9D");
        Card card5 = new Card(14,"AS");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player playerOne = new Player("playerOne",playerOneCardList);
        List<Card> playerTwoCardList = new ArrayList<>();
        Card card6 = new Card(6,"6C");
        Card card7 = new Card(8,"8D");
        Card card8 = new Card(9,"9H");
        Card card9 = new Card(10,"TD");
        Card card10 = new Card(7,"7S");
        playerTwoCardList.add(card6);
        playerTwoCardList.add(card7);
        playerTwoCardList.add(card8);
        playerTwoCardList.add(card9);
        playerTwoCardList.add(card10);
        Player playerTwo = new Player("playerTwo",playerTwoCardList);


        Compare compare = new Compare();
        String result = compare.compare(playerOne,playerTwo);
        Assert.assertEquals("playerOne",result);


    }
}
