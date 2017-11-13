/*Name: James Riback
 * ID: 0466144
 * Date: 11/4/17
 * Description: Assignment8
 */
package javafx;

import javafx.scene.control.*;
import javafx.scene.image.*;
/**
 *
 * @author James
 */
public class Card extends Label
{
    //Field
    String pathString = "file:img\\155.gif";
    Image cardImg = new Image(pathString);
    private int cardVal;
    private Suit suit;
    public Card() //Default constructor
    {
        this("file:img\\155.gif"); //delegating
    }
    public Card(String path2img)
    {
        this.setImage(path2img);
    }
    public Suit getSuit()
    {
        return suit;
    }
    public int getValue() //accessor to cardVal
    {
        return cardVal;
    }
    private void getCardValue(String path2img) //determine card value
    {
        String pathNum = path2img.substring(9, 12);
        int cardFileNum = Integer.parseInt(pathNum);
        if(cardFileNum < 114) //Diamond
        {
            determineCardNum(101, cardFileNum);
            this.suit = Suit.Diamonds;
            
        }
        else if(cardFileNum > 113 && cardFileNum < 127) //Spades
        {
           determineCardNum(114, cardFileNum);
           this.suit = Suit.Clubs; 
           
        }
        else if(cardFileNum > 126 && cardFileNum < 140)
        {
            determineCardNum(127 ,cardFileNum);
            this.suit = Suit.Hearts;
        }
        else
        {
            determineCardNum(140, cardFileNum);
            this.suit = Suit.Spades;
        }
    }
    public Label getCard()
    {
        return this; //returning the instance of a card which is-a label! :O
    }
    public void setImage(String path2img)
    {
        this.pathString = path2img;
        loadCard(pathString);
    }
    private boolean loadCard(String path2img) //loads card object wiith image
    {
        this.cardImg = new Image(path2img);
        this.setGraphic(new ImageView(cardImg));  
        this.getCardValue(path2img);
        return true;
    }
   private void determineCardNum(int minCard, int cardFileNum)
    {
        int cardCount = 1;
        int inc = minCard;
            while(inc != cardFileNum)
            {
                ++inc; 
                ++cardCount;
            }
            if(cardCount == 1)
                cardVal = 11;
            else if(cardCount > 10)
                cardVal = 10;
            else
                cardVal = cardCount;
    }
    
}
