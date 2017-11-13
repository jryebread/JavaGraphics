/*Name: James Riback
 * ID: 0466144
 * Date: 11/4/17
 * Description: Assignment8
 */
package javafx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck extends ArrayList
{
    //Field
   int index = 0;
   final int LAST_CARD = 45;
   
   public Deck()//default constructor
   {
       this("file:img\\"); //delegating 
   }
   public Deck(String path)
   {
       loadCards(path);
   }
   public Card deal()
   {
       if( index >= LAST_CARD)
       {
           shuffle();
           index = 0;
       }
       index++;
       return (Card) this.get(index); //why did i have to cast it as a card?
       //I didnt think it would be this
   }
   public void shuffle()
   {
       Collections.shuffle(this);
   }
   private void loadCards(String path)
   {   int cardCount = 101;      
       for(int x = 0; x < 52; ++x)
       {
           
           this.add(new Card(path + cardCount + ".gif"));
           ++cardCount;
       }
       shuffle();
   }
}
