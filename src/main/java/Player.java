import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private Boolean bust;
    private Boolean sticking;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.bust = false;
        this.sticking = false;
    }

    public String getName(){
        return this.name;
    }

    public int countHand(){
        return this.hand.size();
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public int valueOfHand() {
        int total = 0;
        for (Card card : this.hand){
            int value = card.getValue();

            if(value == 1){
                value += 10;
            }
            total += value;

    }
        return total;
    }

    public void clearHand() {
        this.hand.clear();
    }

    public boolean isBust() {
        return this.bust;
    }

    public void goesBust() {
        this.bust = true;
    }

    public boolean isSticking() {
        return this.sticking;
    }

    public void sticks() {
        this.sticking = true;
    }
}
