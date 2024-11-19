public class Card
{
   private String suit;
   private int value;
   private int rank;
   public Card (int rank, String suit, int value)
   {
      this.rank = rank;
      this.suit = suit;
      this.value = value;
   }

   public int getRank()
   {
      return rank;
   }

   public void setRank(int rank)
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

   public String toString()
   {
      return rank + " of " + suit;
      
   }
}
