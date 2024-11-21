import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<Card> hand;
    private int points;
    public Player (String name)
    {
        this.name = name;
        this.points = 0;
    }
    public Player (String name, ArrayList<Card> hand)
    {
        this.name = name;
        this.points = 0;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points)
    {
        this.points += points;
    }

    public void addCard (Card card)
    {
        hand.add(card);
    }

    public String toString()
    {
        String info = name + " has " + points + " points";
        info += "\n" + name + "'s cards: " + hand;
        return info;
    }
}
