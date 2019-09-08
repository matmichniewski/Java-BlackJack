import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        populateDeck();
        shuffle();
    }



    public ArrayList populateDeck() {
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public int cardCount() {
        return this.cards.size();
    }

    public void dealOne() {
        this.cards.remove(0);
    }
}
