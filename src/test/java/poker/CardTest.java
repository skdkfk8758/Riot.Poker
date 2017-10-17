package poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void 카드_다이아몬드5생성성공() {
        Card card = new Card(5, Suit.HEART);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 5);
        assertTrue(suit == Suit.HEART);
    }

    @Test(expected = NoSearchRankException.class)
    public void 카드_랭크14이상카드생성시에러발생() {
        Card card = new Card(14,Suit.HEART);
    }

    @Test(expected = NoSearchRankException.class)
    public void 카드_랭크0이하카드생성시에러발생() {
        Card card = new Card(0,Suit.HEART);
    }


}
