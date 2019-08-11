package TDDTASK;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandsTest {

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_in_high_card_level() {

        //given
        String[] win2 = {"2C", "4S", "5H", "7H", "9H"};
        String[] win1 = {"2H", "3C", "4S", "5H", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_in_high_card_level_and_type_j_or_q_or_k() {

        //given
        String[] win2 = {"9C", "TS", "JH", "QH", "7C"};
        String[] win1 = {"9H", "TC", "JS", "QD", "AH"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }

//    @Test
//    public void should_return_2_win_when_poker_hands_with_two_poker_array_in_high_card_level_and_in_straight() {
//
//        //given
//        String[] win2 = {"9C", "TS", "JH", "QH", "KH"};
//        String[] win1 = {"9H", "TC", "JS", "QD", "AH"};
//        PokerHands pokerHands = new PokerHands();
//        //when
//        String winer = pokerHands.getWiner(win1, win2);
//        //then
//        Assert.assertEquals("win2", winer);
//
//    }


}