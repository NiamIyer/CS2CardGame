public class Card
{
   // Initializes suit, value, and rank variables
   private String suit;
   private int value;
   private String rank;
   // Initializes them in constructor
   public Card (String rank, String suit, int value)
   {
      this.rank = rank;
      this.suit = suit;
      this.value = value;
   }
   // Getter and setter methods for each instance variable
   public String getRank()
   {
      return rank;
   }

   public void setRank(String rank)
   {
      this.rank = rank;
   }

   public int getValue()
   {
      return value;
   }

   public void setValue(int value)
   {
      this.value = value;
   }

   public String getSuit()
   {
      return suit;
   }

   public void setSuit(String suit)
   {
      this.suit = suit;
   }
   // toString method for card
   public String toString()
   {
      return rank + " of " + suit;
      
   }
}
