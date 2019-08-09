package TDDTASK;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public  class PokerHandsTest {

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_list() {

        //given
//       String[] win1={"1h","3c","4s","5h","7h"};
//       String[] win2={"2h","4c","5s","7h","9h"};
        PokerCard pokerCard1=new PokerCard(1,"h");
        PokerCard pokerCard2=new PokerCard(3,"c");
        PokerCard pokerCard3=new PokerCard(4,"s");
        PokerCard pokerCard4=new PokerCard(5,"h");
        PokerCard pokerCard5=new PokerCard(7,"h");
        List<PokerCard> list = new ArrayList<>();
        list.add(pokerCard1);
        list.add(pokerCard2);
        list.add(pokerCard3);
        list.add(pokerCard4);
        list.add(pokerCard5);

        Winer winer1 = new Winer();
        winer1.setPokerCards(list);
        PokerCard pokerCards1=new PokerCard(1,"h");
        PokerCard pokerCards2=new PokerCard(3,"c");
        PokerCard pokerCards3=new PokerCard(4,"s");
        PokerCard pokerCards4=new PokerCard(5,"h");
        PokerCard pokerCards5=new PokerCard(7,"h");
        List<PokerCard> list2 = new ArrayList<>();
        list2.add(pokerCards1);
        list2.add(pokerCards2);
        list2.add(pokerCards3);
        list2.add(pokerCards4);
        list2.add(pokerCards5);

        Winer winer2 = new Winer();
        winer1.setPokerCards(list);

        //when
        PokerHands pokerHands=new PokerHands();
        String winer = pokerHands.getWiner(win1, win2);
        Assert.assertEquals("win2", winer);

        //then
    }

}