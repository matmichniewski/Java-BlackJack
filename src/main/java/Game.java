import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players) {
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
    }


    public int countPlayers() {
        return this.players.size();
    }

    public void dealCards() {
        Card dealerCard1 = dealer.dealCard(deck);
        Card dealerCard2 = dealer.dealCard(deck);
        dealer.addCard(dealerCard1);
        dealer.addCard(dealerCard2);

        for (Player player : this.players) {
            Card card1 = dealer.dealCard(deck);
            Card card2 = dealer.dealCard(deck);
            player.addCard(card1);
            player.addCard(card2);
        }
    }

    public boolean isPlayerBust(Player player) {
        if (player.valueOfHand() > 21) {
            player.goesBust();
        }
        return player.isBust();
    }

    public boolean isDealerBust(Dealer dealer) {
        if (dealer.valueOfHand() > 21) {
            dealer.goesBust();
        }
        return dealer.isBust();
    }

    public ArrayList<Player> nonBustPlayers() {
        ArrayList<Player> nonBustPlayers = new ArrayList<Player>();

        for (Player player : this.players) {
            if (!this.isPlayerBust(player)) {
                nonBustPlayers.add(player);
            }
        }
        return nonBustPlayers;
    }


    public Object checkWinner() {
        if (!this.checkDraw());


        ArrayList<Player> nonBustPlayers = this.nonBustPlayers();

        Player winner = nonBustPlayers.get(0);

        for (Player player : nonBustPlayers) {
            if (player.valueOfHand() > winner.valueOfHand()) {
                winner = player;
            }
        }
        if (!this.isDealerBust(dealer)) {
            if (winner.valueOfHand() > dealer.valueOfHand()) {
                return winner;
            } else {
                return dealer;
            }
        }
        return winner;

    }

    public boolean checkDraw() {
        Boolean draw = false;

        for (Player player : this.players) {
            if (player.valueOfHand() == players.get(0).valueOfHand() && player.valueOfHand() == dealer.valueOfHand()) {
                draw = true;
            } else {
                draw = false;
            }
        }
        return draw;
    }

    public void twist(Player player) {
        Card card = dealer.dealCard(deck);
        player.addCard(card);
    }

    public void twist(Dealer dealer) {
        Card card = dealer.dealCard(deck);
        dealer.addCard(card);
    }

    public void playerTurn(Player player, String choice) {
        if (choice == "twist") {
            twist(player);
        } else if (choice == "stick") {
            player.sticks();
        }
    }

    public void dealerTurn(Dealer dealer) {
        if (dealer.valueOfHand() <= 16) {
            twist(dealer);
        } else {
            dealer.sticks();
        }
    }
}


