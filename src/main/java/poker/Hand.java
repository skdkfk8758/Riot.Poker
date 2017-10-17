package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    ArrayList<Card> handList = new ArrayList<Card>();

    public void addCard(Card card) {
        if (handList.size() >= 5) {
            throw new NoMoreHandException();
        }
        handList.add(card);
    }

    public int getCardCount() {
        return handList.size();
    }

    public ArrayList<Card> getCardList() {
        return handList;
    }
}
