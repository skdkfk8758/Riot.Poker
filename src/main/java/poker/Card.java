package poker;

//    Card
//    Hand 5장
//    족보 Evaluator
//    Deck
//    Player

public class Card implements Comparable<Card>{

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) throws NoSearchRankException {
        if (rank > 13 || rank <= 0) {
            throw new NoSearchRankException();
        }
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int compareTo(Card o) {
        if(rank > o.getRank()){
            return 1;
        }
        else if (rank < o.getRank()){
            return -1;
        }
        return 0;
    }
}
