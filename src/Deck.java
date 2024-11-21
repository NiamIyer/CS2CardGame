import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;
    private int cardsLeft;
    public Deck (String[] rank, String[] suits, int[] value)
    {
        for (String suit: suits)
        {
            for (int i = 0; i < rank.length; i++)
            {
                Card newCard = new Card(rank[i], suit, value[i]);
                cards.add(newCard);
            }
        }
        cardsLeft = cards.size();

    }

    public boolean isEmpty()
    {
        if (cardsLeft == 0);
        {
            return true;
        }
        return false;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public Card deal()
    {
        if (isEmpty())
        {
            return null;
        }
        cardsLeft --;
        return cards.get(cardsLeft);
    }

    public void shuffle()
    {
        cardsLeft = cards.size();
        int r;
        for (int i = cards.size(); i > 0; i--)
        {
            r = (int) (Math.random() * i);
            Card myCard = cards.get(i);
            cards.set(i,cards.get(r));
            cards.set(r, myCard);
        }
    }
}
