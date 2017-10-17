package poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeckTest {

    @Test
    public void Deck_한개의총카드는52장이다(){
        Deck deck = new Deck(1);
        assertTrue(deck.getTotalCard() == 52);
    }

    @Test
    public void Deck_한개에서카드한장을뽑으면총카드수는51장(){
        Deck deck = new Deck(1);
        Card card = deck.drawCard();
        assertTrue(deck.getTotalCard() == 51);
    }

    @Test(expected = NoMoreCardException.class)
    public void Deck_비어있는데뽑으면에러발생(){
        Deck deck = new Deck(1);
        for (int i=0; i<52; i++){
            Card card = deck.drawCard();
            System.out.printf(card.getRank() + ":" + card.getSuit() + "\n");
        }
        deck.drawCard();
    }
}
