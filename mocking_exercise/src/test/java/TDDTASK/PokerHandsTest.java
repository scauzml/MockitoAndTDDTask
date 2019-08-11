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
    public void should_return_1_win_when_poker_hands_with_two_poker_array_in_high_card_level_and_type_j_or_q_or_k() {

        //given
        String[] win2 = {"9C", "TS", "JH", "QH", "7C"};
        String[] win1 = {"9H", "TC", "JS", "QD", "AH"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }


    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_in_high_card_level_and_in_pair_level() {

        //given
        String[] win2 = {"9C", "TS", "JH", "QH", "QC"};
        String[] win1 = {"9H", "8C", "JS", "QD", "AH"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_and_in_pair() {

        //given
        String[] win2 = {"2C", "2S", "4H", "5H", "7C"};
        String[] win1 = {"3H", "3C", "4S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_card_level_and_in_pair_with_pair_is_equal() {

        //given
        String[] win2 = {"2C", "2S", "4H", "5H", "7C"};
        String[] win1 = {"2H", "2d", "3S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_pair_with_max_card_num() {

        //given
        String[] win2 = {"2C", "2S", "4H", "5H", "7C"};
        String[] win1 = {"2H", "2d", "3S", "5D", "9H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_card_level_in_two_pair_with_one_pair_is_equal() {

        //given
        String[] win2 = {"2C", "2S", "4H", "4H", "7C"};
        String[] win1 = {"2H", "2d", "3S", "3D", "9H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_card_level_in_two_pair_with_no_pair_is_equal() {

        //given
        String[] win2 = {"3C", "3S", "4H", "4H", "7C"};
        String[] win1 = {"2H", "2d", "3S", "3D", "9H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);

    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_two_pair_with_no_pair_is_equal2() {

        //given
        String[] win2 = {"3C", "3S", "4H", "4H", "7C"};
        String[] win1 = {"2H", "2d", "5S", "5D", "9H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_two_pair_with_all_equal() {

        //given
        String[] win2 = {"2C", "2S", "4H", "4H", "7C"};
        String[] win1 = {"2H", "2d", "4S", "4D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("no win", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_two_pair_and_pair() {

        //given
        String[] win2 = {"2C", "2S", "4H", "5H", "7C"};
        String[] win1 = {"2H", "2d", "4S", "4D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_three_of_a_kind() {

        //given
        String[] win2 = {"2C", "2S", "2H", "5H", "9C"};
        String[] win1 = {"3H", "3d", "3S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);

    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_three_of_a_kind_and_high_card() {

        //given
        String[] win2 = {"2C", "4S", "5H", "7H", "9H"};
        String[] win1 = {"3H", "3d", "3S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_three_of_a_kind_and_pair() {

        //given
        String[] win2 = {"2C", "2S", "4H", "5H", "7C"};
        String[] win1 = {"3H", "3d", "3S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight() {

        //given
        String[] win2 = {"2C", "3S", "4H", "5H", "6C"};
        String[] win1 = {"3H", "4d", "5S", "6D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight_with_all_code_same() {

        //given
        String[] win2 = {"2C", "3S", "4H", "5H", "6C"};
        String[] win1 = {"2H", "3d", "4S", "5D", "6H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("no win", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight_and_three_of_a_kind() {

        //given
        String[] win2 = {"2C", "3S", "4H", "5H", "6C"};
        String[] win1 = {"3H", "3d", "3S", "5D", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_flush() {

        //given
        String[] win2 = {"2C", "3C", "4C", "5C", "7C"};
        String[] win1 = {"3S", "4S", "5S", "6S", "8S"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_2_win_when_poker_hands_with_two_poker_array_card_level_in_flush_only_min_code_is_no_equal() {

        //given
        String[] win2 = {"4C", "5C", "6C", "7C", "8C"};
        String[] win1 = {"3S", "5S", "6S", "7S", "8S"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win2", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_flush_and_in_straight() {

        //given
        String[] win2 = {"2C", "3S", "4H", "5H", "6C"};
        String[] win1 = {"3S", "5S", "6S", "7S", "8S"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_full_house() {

        //given
        String[] win2 = {"3C", "3S", "6H", "6S", "3d"};
        String[] win1 = {"4S", "4C", "5S", "5D", "4H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_full_house_and_flush() {

        //given
        String[] win2 = {"2C", "3S", "4H", "5H", "6C"};
        String[] win1 = {"4S", "4C", "5S", "5D", "4H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_four_of_a_kind() {

        //given
        String[] win2 = {"2C", "2S", "2H", "2D", "6C"};
        String[] win1 = {"4S", "4C", "4H", "4D", "5H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_four_of_a_kind_and_full_house() {

        //given
        String[] win2 = {"3S", "3C", "5S", "5D", "3H"};
        String[] win1 = {"4S", "4C", "4H", "4D", "5H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight_flush() {

        //given
        String[] win2 = {"2S", "3S", "5S", "4S", "6S"};
        String[] win1 = {"4H", "5H", "6H", "8H", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight_flush_and_four_of_a_kind() {

        //given
        String[] win2 = {"4S", "4C", "4H", "4D", "5H"};
        String[] win1 = {"4H", "5H", "6H", "8H", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("win1", winer);
    }

    @Test
    public void should_return_1_win_when_poker_hands_with_two_poker_array_card_level_in_straight_flush_all_same_code(){

        //given
        String[] win2 = {"4S", "5S", "6S", "7S", "8S"};
        String[] win1 = {"4H", "5H", "6H", "8H", "7H"};
        PokerHands pokerHands = new PokerHands();
        //when
        String winer = pokerHands.getWiner(win1, win2);
        //then
        Assert.assertEquals("no win", winer);
    }


}