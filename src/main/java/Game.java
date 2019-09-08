import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer delaer;
    private Deck deck;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players){
        this.players = players;
        this.deck = deck;
        this.delaer = dealer;
    }

    

}
