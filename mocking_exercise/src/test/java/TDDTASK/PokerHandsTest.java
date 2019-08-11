package TDDTASK;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandsTest {

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_list() {

        //given
        String[] win2 = {"2C", "4S", "5H", "7H", "9H"};
        String[] win1 = {"2H", "3C", "4S", "5H", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

}