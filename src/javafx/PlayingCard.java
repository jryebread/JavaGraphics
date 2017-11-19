/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author James
 */
public class PlayingCard extends Card {
    //Field
    private int cardVal; //holds card face value
    private Suit suit;
    
    //OVERRIDE ABSTRACT METHOD 
    @Override
    public boolean loadCard(String path2img)
    {
        this.cardImage = new Image(path2img);
        this.setGraphic(new ImageView(cardImage));  
        this.getCardValue(path2img);
        return true;
    }
    
    public PlayingCard() //Default constructor
    {
        this("file:img\\155.gif"); //delegating
    }
    public PlayingCard(String path2img)
    {
        super(path2img);
    }
     public Suit getSuit() //accessor to suit
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
