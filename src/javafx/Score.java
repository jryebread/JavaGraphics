/*Name: James Riback
 * ID: 0466144
 * Date: 11/4/17
 * Description: Assignment8
 */
package javafx;

/**
 *
 * @author James
 */
public class Score {
    //Data Field
    private static int scoreLeft;
    private static int scoreRight;
    private Score() {}
    //Accessor Methods
    public static int getRightScore()
    {
        return scoreRight;
    }
    public static int getLeftScore()
    {
        return scoreLeft;
    }
    
    //Mutator Methods
    public static void setRightScore(int score)
    {
        scoreRight = score;
    }
    public static void setRightScore(String score)
    {
        scoreRight = Integer.parseInt(score);
    }
    public static void setLeftScore(int score)
    {
        scoreLeft = score;
    }
    public static void setLeftScore(String score)
    {
        scoreLeft = Integer.parseInt(score);
    }
    public static void resetScore()
    {
        scoreRight = 0;
        scoreLeft = 0;
    }
}
