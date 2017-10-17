package poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HandTest {

    @Test
    public void Hand_카드를한장뽑으면Hand는한장이다(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        Card card = deck.drawCard();
        hand.addCard(card);
        assertTrue(hand.getCardCount() == 1);
    }

    @Test(expected = NoMoreHandException.class)
    public void Hand_카드를5장넘게뽑으면에러발생() {
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        for (int i = 0; i < 6; i++) {
            hand.addCard(deck.drawCard());
            System.out.println(hand.getCardCount());
        }
    }
}
