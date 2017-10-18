package poker;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EvaluatorTest {

    @Test
    public void 로열스트레이트플러시검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(10,Suit.HEART));
        hand.addCard(new Card(11,Suit.HEART));
        hand.addCard(new Card(12,Suit.HEART));
        hand.addCard(new Card(13,Suit.HEART));
        hand.addCard(new Card(1,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateRoyalStragightFlush(hand);
        assertTrue(result == EvaluatorEnum.ROYAL_STRAIGHT_FLUSH);
    }

    @Test
    public void 로열스트레이트플러시검증실패() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(10,Suit.SPADE));
        hand.addCard(new Card(11,Suit.SPADE));
        hand.addCard(new Card(12,Suit.SPADE));
        hand.addCard(new Card(13,Suit.SPADE));
        hand.addCard(new Card(2,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateRoyalStragightFlush(hand);
        assertFalse(result == EvaluatorEnum.ROYAL_STRAIGHT_FLUSH);
    }

    @Test
    public void 백스트레이트플러시검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.SPADE));
        hand.addCard(new Card(2,Suit.SPADE));
        hand.addCard(new Card(3,Suit.SPADE));
        hand.addCard(new Card(4,Suit.SPADE));
        hand.addCard(new Card(5,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateBackStragightFlush(hand);
        assertTrue(result == EvaluatorEnum.BACK_STRAIGHT_FLUSH);
    }

    @Test
    public void 백스트레이트플러시검증실패() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.SPADE));
        hand.addCard(new Card(2,Suit.SPADE));
        hand.addCard(new Card(3,Suit.SPADE));
        hand.addCard(new Card(4,Suit.SPADE));
        hand.addCard(new Card(6,Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateBackStragightFlush(hand);
        assertFalse(result == EvaluatorEnum.BACK_STRAIGHT_FLUSH);
    }

    @Test
    public void 스트레이트플러시검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(2,Suit.HEART));
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(5,Suit.HEART));
        hand.addCard(new Card(1,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateStragightFlush(hand);
        assertTrue(result == EvaluatorEnum.STRAIGHT_FLUSH);
    }

    @Test
    public void 스트레이트플러시검증실패() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(7,Suit.HEART));
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(5,Suit.HEART));
        hand.addCard(new Card(1,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateStragightFlush(hand);
        assertTrue(result != EvaluatorEnum.STRAIGHT_FLUSH);
    }

    @Test
    public void 포카드검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(7,Suit.SPADE));
        hand.addCard(new Card(7,Suit.CLUB));
        hand.addCard(new Card(7,Suit.DIAMOND));
        hand.addCard(new Card(7,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateFourCard(hand);
        assertTrue(result == EvaluatorEnum.FOUR_CARD);
    }

    @Test
    public void 포카드검증실패() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(7,Suit.SPADE));
        hand.addCard(new Card(7,Suit.CLUB));
        hand.addCard(new Card(7,Suit.DIAMOND));
        hand.addCard(new Card(9,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateFourCard(hand);
        assertTrue(result != EvaluatorEnum.FOUR_CARD);
    }

    @Test
    public void 플러시검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.HEART));
        hand.addCard(new Card(2,Suit.HEART));
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(9,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateFlush(hand);
        assertTrue(result == EvaluatorEnum.FLUSH);
    }

    @Test
    public void 플러시검증실패() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.DIAMOND));
        hand.addCard(new Card(2,Suit.HEART));
        hand.addCard(new Card(3,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(9,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateFlush(hand);
        assertTrue(result != EvaluatorEnum.FLUSH);
    }

    @Test
    public void 원페어검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.DIAMOND));
        hand.addCard(new Card(2,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(9,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateOnePair(hand);
        assertTrue(result == EvaluatorEnum.ONE_PAIR);
    }

    @Test
    public void 트리플검증성공() throws NoFullHandException {
        Hand hand = new Hand();

        hand.addCard(new Card(1,Suit.DIAMOND));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(4,Suit.HEART));
        hand.addCard(new Card(9,Suit.HEART));

        Evaluator evaluator = new Evaluator();
        EvaluatorEnum result = evaluator.evaluateTriple(hand);
        assertTrue(result == EvaluatorEnum.TRIPLE);
    }






}
