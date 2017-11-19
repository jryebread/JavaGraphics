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
abstract public class Card extends Label
{
    //ABSTRACT METHOD
    abstract public boolean loadCard(String path2img); 
    
    //Field
    protected String cardPath;
    protected Image cardImage;
 

    public Card() //Default constructor
    {
        this("file:img\\155.gif"); //delegating
    }
    public Card(String path2img)
    {
        this.setImage(path2img);
    }
    public Label getCard()
    {
        return this; //returning the instance of a card which is-a label! :O
    }
    private void setImage(String path2img)
    {
        this.cardPath = path2img;
        loadCard(cardPath);
    }
    
}
