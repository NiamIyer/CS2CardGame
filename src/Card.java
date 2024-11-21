public class Card
{
   private String suit;
   private int value;
   private String rank;
   public Card (String rank, String suit, int value)
   {
      this.rank = rank;
      this.suit = suit;
      this.value = value;
   }

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

   public String toString()
   {
      return rank + " of " + suit;
      
   }
}
