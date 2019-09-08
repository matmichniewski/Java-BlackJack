import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;
    private Boolean bust;
    private Boolean sticking;

    public Dealer() {
        this.cards = new ArrayList<Card>();
        this.bust = false;
        this.sticking = false;
    }


    public int countHand() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card dealCard(Deck deck) {
        return deck.dealOne();
    }

    public int valueOfHand() {
        int total = 0;
        for (Card card : this.cards){
            int value = card.getValue();
            total += value;
        }
        return total;
    }

    public boolean isSticking() {
        return this.sticking;
    }

    public void sticks() {
        this.sticking = true;
    }

    public boolean isBust() {
        return this.bust;
    }

    public void goesBust() {
        this.bust = true;
    }
}
