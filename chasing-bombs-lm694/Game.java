import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Game here.
 *
 * @author (Lucy Mercer)
 * @version (6/3/19)
 */
public class Game extends JFrame 
{
    private JFrame frame = new JFrame("Game");
    private JPanel left, center, right, one, two, three, four, five, six, seven, eight, nine, ten;
    private JLabel score;
    private JButton play, exit, beginner, intermediate, difficult;
    
    private int tries = 5;
    private int moves = 0;
    private int random = (int)(Math.random() * 9 + 1);
    private int scores = 0;
    private boolean bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bTen;
    
    /**
     * Constructor for class Game
     */
    public Game() {
        setSize(765, 500);
        setLayout(new FlowLayout());
        createFrame();
        setVisible(true);
    }
    
    /**
     * Creates the frame. splits into 3 main panels, and 10 panels within the 
     * left hand panel.
     */
    public void createFrame() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Creates the left hand pane
        left = new JPanel();
        left.setLayout(new GridLayout(2,5,2,2));
        left.setPreferredSize(new Dimension(250, 500));
        
        //Creates the centre pane
        center = new JPanel();
        center.setBackground(Color.BLUE);
        center.setPreferredSize(new Dimension(250, 500));
        
        //Creates the right hand pane
        right = new JPanel();
        right.setBackground(Color.GREEN);
        right.setPreferredSize(new Dimension(250, 500));
        
        //Buttons for centre pane
        play = new JButton("Play the game");
        exit = new JButton("Exit");
        score = new JLabel("Score: "+ scores);
        
        //Buttons for right pane
        beginner = new JButton("Beginner");
        intermediate = new JButton("Intermediate");
        difficult = new JButton("Difficult");
        
        //Create 5x2 buttons
        one = new JPanel();
        one.setBackground(Color.RED);

        two = new JPanel();
        two.setBackground(Color.RED);

        three = new JPanel();
        three.setBackground(Color.RED);

        four = new JPanel();
        four.setBackground(Color.RED);

        five = new JPanel();
        five.setBackground(Color.RED);

        six = new JPanel();
        six.setBackground(Color.RED);

        seven = new JPanel();
        seven.setBackground(Color.RED);

        eight = new JPanel();
        eight.setBackground(Color.RED);

        nine = new JPanel();
        nine.setBackground(Color.RED);
        
        ten = new JPanel();
        ten.setBackground(Color.RED);
        
        
        
        //Makes sure application fully closes 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Adds 3 panes
        add(left);
        add(center);
        add(right);
        
        //Adds the 5x2 buttons to the left pane
        left.add(one);
        left.add(two);
        left.add(three);
        left.add(four);
        left.add(five);
        left.add(six);
        left.add(seven);
        left.add(eight);
        left.add(nine);
        left.add(ten);
        
        //Adds buttons to center pane
        center.add(play);
        center.add(exit);
        center.add(score);
        
        //Adds buttons to right pane
        right.add(beginner);
        right.add(intermediate);
        right.add(difficult);
        
        //Exit button functionality
        exit.addActionListener(e -> this.dispose());

        //Click functionality for panel one
        one.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 1 && bOne != true){
                    one.setBackground(Color.GREEN);
                    bOne = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==1){
                    lose();
                }
            }
        });

        //Click functionality for panel two
        two.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 2 && bTwo != true){
                    two.setBackground(Color.GREEN);
                    bTwo = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==2){
                    lose();
                }
            }
        });

        //Click functionality for panel three
        three.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 3 && bThree != true){
                    three.setBackground(Color.GREEN);
                    bThree = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==3){
                    lose();
                }
            }
        });
        
        //Click functionality for panel four
        four.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 4 && bFour != true){
                    four.setBackground(Color.GREEN);
                    bFour = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==4){
                    lose();
                }
            }
        });
        
        //Click functionality for panel five
        five.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 5 && bFive != true){
                    five.setBackground(Color.GREEN);
                    bFive = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==5){
                    lose();
                }
            }
        });
        
        //Click functionality for panel six
        six.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 6 && bSix != true){
                    six.setBackground(Color.GREEN);
                    bSix = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==6){
                    lose();
                }
            }
        });
        
        //Click functionality for panel seven
        seven.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 7 && bSeven != true){
                    seven.setBackground(Color.GREEN);
                    bSeven = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==7){
                    lose();
                }
            }
        });
        
        //Click functionality for panel eight
        eight.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 8 && bEight != true){
                    eight.setBackground(Color.GREEN);
                    bEight = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==8){
                    lose();
                }
            }
        });
        
        //Click functionality for panel nine
        nine.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 9 && bNine != true){
                    nine.setBackground(Color.GREEN);
                    bNine = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==9){
                    lose();
                }
            }
        });
        
        //Click functionality for panel ten
        ten.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e)
                    {
                        if (random != 10 && bTen != true){
                    ten.setBackground(Color.GREEN);
                    bTen = true;
                    scores = scores + 5;
                    score.setText("Score: "+scores);
                    moves ++;
                    won();
                }
                else if (random ==10){
                    lose();
                }
            }
        });
        
        //Reset game
        play.addActionListener(e -> reset(e));
        //Beginner mode
        beginner.addActionListener(e -> settingBeginner(e));
        //Intermediate mode
        intermediate.addActionListener(e -> settingIntermediate(e));
        //Difficult mode
        difficult.addActionListener(e -> settingDifficult(e));
    }
    
    /**
     * Won is called when the player reaches the required amount of tries
     * without hitting the bomb. Also sets the panels to true so that they
     * are no longer clickable. Removes bomb so that you cannot lose after
     * you have won.
     */
    public void won(){
        if (moves == tries){
            score.setText("Youve won");
            bOne = true;
            bTwo = true;
            bThree = true;
            bFour = true;
            bFive = true;
            bSix = true;
            bSeven = true;
            bEight = true;
            bNine = true;
            bTen = true;
            random = 0;
        }
    }
    
    /**
     * Resets the panels, score, and moves to their original state and
     * generates new location for bomb.
     */
    public void reset(ActionEvent e){
        scores = 0;
        moves = 0;
        bOne = false;
        bTwo = false;
        bThree = false;
        bFour = false;
        bFive = false;
        bSix = false;
        bSeven = false;
        bEight = false;
        bNine = false;
        bTen = false;
        one.setBackground(Color.RED);
        two.setBackground(Color.RED);
        three.setBackground(Color.RED);
        four.setBackground(Color.RED);
        five.setBackground(Color.RED);
        six.setBackground(Color.RED);
        seven.setBackground(Color.RED);
        eight.setBackground(Color.RED);
        nine.setBackground(Color.RED);
        ten.setBackground(Color.RED);
        random = (int)(Math.random() * 9 + 1);
        score.setText("Score: "+scores);
    }
    
    /**
     * Lose is called when the player hits the bomb, sets all panels to
     * true so that they are no longer clickable and cannot be highlighted
     */
    public void lose(){
        score.setText("Youve lost, you got "+scores+" points");
            bOne = true;
            bTwo = true;
            bThree = true;
            bFour = true;
            bFive = true;
            bSix = true;
            bSeven = true;
            bEight = true;
            bNine = true;
            bTen = true;
    }
    
    /**
     * Sets the amount of attempts to 5
     */
    public void settingBeginner(ActionEvent e){
        tries = 5;
    }
    
    /**
     * Sets the amount of attempts to 7
     */
    public void settingIntermediate(ActionEvent e){
        tries = 7;
    }
    
    /**
     * Sets the amount of attempts to 9
     */
    public void settingDifficult(ActionEvent e){
        tries = 9;
    }

}
