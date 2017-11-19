/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author James
 */
public class TarotCard extends Card {
    
    private int tarotVal;
    private String tarotName;
    
    @Override
    public boolean loadCard(String path)
    {
        this.cardImage = new Image(path);
        this.setGraphic(new ImageView(cardImage));  
        this.getCardValue(path);
        return true;
    }
   public TarotCard() //Default constructor
    {
        this("file:img\\Tarot\\maj_00.jpg"); //delegating
    }
    public TarotCard(String path2img)
    {
        super(path2img); //base class constructor
    }
    
    public int getValue()
    {
        return tarotVal;
    }
    public String getName()
    {
        return tarotName;
    }
    public void getCardValue(String path)
    {
        tarotVal = Integer.parseInt(path.substring(19, 21));
        tarotName = path.substring(15, path.length()-4);
        
    }
}
