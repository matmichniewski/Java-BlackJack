import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;
    Deck deck;
    Card card1;
    Card card2;

    @Before
    public void before(){
        player1 = new Player("John");
        player2 = new Player("Steven");
        deck = new Deck();
        card1 = new Card(Suit.DIAMONDS, Rank.THREE);
        card2 = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    public void canGetName(){
        assertEquals("John", player1.getName());
    }

    @Test
    public void startsWithEmptyHand(){
        assertEquals(0, player1.countHand());
    }

    @Test
    public void canAddCard(){
        player1.addCard(card1);
        assertEquals(1, player1.countHand());
    }

    @Test
    public void canGetValueOfHand(){
        player1.addCard(card1);
        player1.addCard(card2);
        assertEquals(13, player1.valueOfHand());
    }

    @Test
    public void canClearHand(){
        player1.addCard(card1);
        player1.addCard(card2);
        player1.clearHand();
        assertEquals(0, player1.countHand());
    }

    @Test
    public void startsNotBust(){
        assertEquals(false, player1.isBust());
    }

    @Test
    public void canBeBust(){
        player1.goesBust();
        assertEquals(true, player1.isBust());
    }

    @Test
    public void startsNotSticking(){
        assertEquals(false, player1.isSticking());
    }


}
