import java.util.ArrayList;

public class Deck
{
    // Instance variables
    private ArrayList<Card> cards;
    private int cardsLeft;
    // Constructor which sets all the cards using a nested for loop
    // Constructor takes in set of ranks, suits and values and creates cards for all possible ranks and suits
    // Assigns the value to each card in same loop based off rank
    public Deck (String[] rank, String[] suits, int[] value)
    {
        cards = new ArrayList<Card>();
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
    // Checks if there are any cards left
    public boolean isEmpty()
    {
        return (cardsLeft == 0);

    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }
    // Checks if deck is empty, and if not it decrements the amount of cards left and returns a card at that index
    // Returns at that index because the deck starts at index 0
    public Card deal()
    {
        if (isEmpty()) {
            return null;
        }
        cardsLeft --;
        return cards.get(cardsLeft);
    }
    // Shuffles deck by swapping random cards
    public void shuffle()
    {
        cardsLeft = cards.size();
        int r;
        for (int i = cards.size() - 1; i > 0; i--)
        {
            r = (int) (Math.random() * i);
            Card myCard = cards.get(i);
            cards.set(i,cards.get(r));
            cards.set(r, myCard);
        }
    }
}
