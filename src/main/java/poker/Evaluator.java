package poker;

import java.util.*;

public class Evaluator {

    public EvaluatorEnum evaluateRoyalStragightFlush(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int royalStraightFlushArray[] = {1, 10, 11, 12, 13};
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getSuit() != card.getSuit()) {
                    isEvaluator = false;
                    break;
                } else {
                    for (int royal : royalStraightFlushArray) {
                        if (royal == card.getRank()) {
                            if (royal == card.getRank()) {
                                check++;
                            }
                            if (check == handList.size()) {
                                isEvaluator = true;
                            }
                        }
                    }
                }
            }
        }


        if (isEvaluator)
            return EvaluatorEnum.ROYAL_STRAIGHT_FLUSH;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateBackStragightFlush(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int backStraightFlushArray[] = {1, 2, 3, 4, 5};
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getSuit() != card.getSuit()) {
                    isEvaluator = false;
                    break;
                } else {
                    for (int royal : backStraightFlushArray) {
                        if (royal == card.getRank()) {
                                check++;
                            if (check == handList.size()) {
                                isEvaluator = true;
                            }
                        }
                    }
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.BACK_STRAIGHT_FLUSH;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateStragightFlush(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Collections.sort(handList);
        Card tmpCard = handList.get(0);
        handList.remove(tmpCard);

        if (hand.getCardCount() != 4) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getSuit() != card.getSuit()) {
                    isEvaluator = false;
                    break;
                } else {
                    for (Card card2 : handList) {
                        if ((tmpCard.getRank() + 1) == card2.getRank()) {
                            check++;
                            tmpCard = card2;
                            if (check == handList.size()) {
                                isEvaluator = true;
                            }
                        }
                    }
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.STRAIGHT_FLUSH;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateStragight(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Collections.sort(handList);
        Card tmpCard = handList.get(0);
        handList.remove(tmpCard);

        if (hand.getCardCount() != 4) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                {
                    for (Card card2 : handList) {
                        if ((tmpCard.getRank() + 1) == card2.getRank()) {
                            check++;
                            tmpCard = card2;
                            if (check == handList.size()) {
                                isEvaluator = true;
                            }
                        }
                    }
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.STRAIGHT;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateFourCard(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getRank() == card.getRank()) {
                    check++;
                    tmpCard = card;
                }
                if (check == 4) {
                    isEvaluator = true;
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.FOUR_CARD;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateFlush(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getSuit() == card.getSuit()){
                    check ++;
                    tmpCard = card;
                }
                if (check == 5){
                    isEvaluator = true;
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.FLUSH;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateOnePair(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getRank() == card.getRank()) {
                    check++;
                    tmpCard = card;
                } else{
                    tmpCard = card;
                }
                if (check == 2) {
                    isEvaluator = true;
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.ONE_PAIR;
        else
            return EvaluatorEnum.NONE;
    }

    public EvaluatorEnum evaluateTriple(Hand hand) {
        boolean isEvaluator = false;
        List<Card> handList = hand.getCardList();
        int check = 0;
        Card tmpCard = handList.get(0);

        if (hand.getCardCount() != 5) {
            throw new NoFullHandException();
        } else {
            for (Card card : handList) {
                if (tmpCard.getRank() == card.getRank()) {
                    check++;
                    tmpCard = card;
                } else{
                    tmpCard = card;
                }
                if (check == 3) {
                    isEvaluator = true;
                }
            }
        }
        if (isEvaluator == true)
            return EvaluatorEnum.TRIPLE;
        else
            return EvaluatorEnum.NONE;
    }



}
