/*Name: James Riback
 * ID: 0466144
 * Date: 11/4/17
 * Description: Assignment8
 */
package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.image.*;
 import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import java.util.Random;
import javafx.geometry.Pos;


public class JavaFX extends Application 
{
            Deck deck = new Deck();
            Label lblCardLeft = new Label();
            Label lblCardRight = new Label();
            Label lblCardDeck = new Label();
            int rightVal = 0, leftVal = 0;
            boolean rightsTurn = true;
            
    @Override
    public void start(Stage primaryStage) {
        
  
            Label lblScore = new Label("Score:");
            
            Font fntTop = Font.font("Arial", FontWeight.BOLD, 15.0);
            lblScore.setFont(fntTop);
            lblScore.setTextFill(Color.PURPLE);
           
            TextField tfLeft = new TextField();
            tfLeft.setPrefWidth(50);
            tfLeft.setDisable(true);
            tfLeft.setText("0");
            TextField tfRight = new TextField();
            tfRight.setPrefWidth(50);
            tfRight.setDisable(true);
            tfRight.setText("0");
        
            lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    String str = "file:img\\";
                    Random rand = new Random();
                    //152 is the maximum and the 101 is our minimum 
                    int max = 152; int min = 101;
                    int rng = rand.nextInt((max - min) + 1) + min;
                    str = str + rng + ".gif";
                    
                    if(rightsTurn)
                    {
                        Card newRightCard = deck.deal();
                        lblCardRight.setGraphic(newRightCard);
                        rightVal = newRightCard.getValue();
                    }
                    else
                    {
                        Card newLeftCard = deck.deal();
                        lblCardLeft.setGraphic(newLeftCard); 
                        leftVal = newLeftCard.getValue();
                    }
                    if(rightVal > leftVal && leftVal != 0)
                    {
                        Score.setRightScore(Score.getRightScore() + rightVal); //add to score new val utilizing static score class
                        tfRight.setText(""+Score.getRightScore());
                    }
                    else if(leftVal > rightVal && leftVal != 0)
                    {
                        Score.setLeftScore(Score.getLeftScore() + leftVal); 
                        tfLeft.setText(""+Score.getLeftScore());
                    }
                    
                    rightsTurn = !rightsTurn;
                }
            });
             //Resets cards to card back
              resetCardImages();
              
            BorderPane root = new BorderPane();
            GridPane topPane = new GridPane();
            GridPane cardPane = new GridPane();
            Button reset = new Button("Reset");
            root.setBottom(reset);
            
            //ResetButton
            reset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rightVal = 0;
                leftVal = 0;
                Score.resetScore();
                tfRight.setText("0");
                tfLeft.setText("0");
                rightsTurn = true;
                resetCardImages();
            }
        });
            
            //Drop Shadow reset btn
            DropShadow ds = new DropShadow();
            reset.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    reset.setEffect(ds);
                }
            });
            reset.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    reset.setEffect(null);
                }
            });
          
            //TOPPANE
            topPane.add(lblScore, 0, 0);
            topPane.add(new Label("Left:"), 1, 0);
            topPane.add(tfLeft, 1,1);
            topPane.add(new Label("Right:"), 2, 0);
            topPane.add(tfRight, 2, 1);
            topPane.setHgap(20);
            topPane.setVgap(10);
            root.setTop(topPane);
            
            //CENTERPANE
            cardPane.setHgap(20);
            cardPane.add(lblCardLeft, 0, 0);
            cardPane.add(lblCardDeck, 1, 0);
            cardPane.add(lblCardRight, 2, 0);
            cardPane.setAlignment(Pos.CENTER);
            root.setCenter(cardPane);
          
            //set primary stage
            Scene scene = new Scene(root, 300, 250); //create primary stage
            primaryStage.setTitle("Wizard"); //set title
            primaryStage.setScene(scene); //set scene of primary stage
            
            primaryStage.show();
        }
    public void resetCardImages()
    {
        Card cardLeft = new Card();
        Card cardRight = new Card();
        Card cardDeck = new Card();
        lblCardLeft.setGraphic(cardLeft);
        lblCardRight.setGraphic(cardRight);
        lblCardDeck.setGraphic(cardDeck);
    }
  
    public static void main(String[] args) {
        launch(args);
        
    }
}
