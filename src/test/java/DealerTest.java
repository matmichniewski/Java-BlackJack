import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Deck deck;
    Card card;
    Player player1;
    Player player2;

    @Before
    public void before(){
        dealer = new Dealer();
        deck = new Deck();
        card = new Card(Suit.SPADES, Rank.KING);
        player1 = new Player("John");
        player2 = new Player("Steven");
    }

    @Test
    public void canAddCard(){
        dealer.addCard(card);
        assertEquals(1, dealer.countHand());
    }

    @Test
    public void canDealCardFromDeck(){
        dealer.dealCard(deck);
        assertEquals(51, deck.cardCount());
    }

    @Test
    public void canGetValueOfHand(){
        dealer.addCard(card);
        assertEquals(10, dealer.valueOfHand());
    }

    @Test
    public void startsNotSticking(){
        assertEquals(false, dealer.isSticking());
    }

    @Test
    public void canStick(){
        dealer.sticks();
        assertEquals(true, dealer.isSticking());
    }

    @Test
    public void startsNotBust(){
        assertEquals(false, dealer.isBust());
    }

    @Test
    public void canBust(){
        dealer.goesBust();
        assertEquals(true, dealer.isBust());
    }


}
