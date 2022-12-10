import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private int score = 0;
    private int brickY = 7;
    private int brickX = 5;
    private MapGenerator map;
    private Timer timer;
    private int playerX = 310;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private boolean play = false;
    private boolean pause = false;
    private int delay = 8;
    private int totalBricks;

    public GamePlay () {
        map = new MapGenerator(brickX,brickY);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics graphic) {
        
        //Background
        graphic.setColor(Color.black);
        graphic.fillRect(1,1,692,592);

        //Drawing map
        totalBricks = map.draw((Graphics2D) graphic);
        System.out.println(totalBricks);

        //Setting Borders
        graphic.setColor(Color.black);
        graphic.fillRect(0,0,3,592);
        graphic.fillRect(0,0,692,3);
        graphic.fillRect(691,0,3,592);

        //score counter
        graphic.setColor(Color.white);
        graphic.setFont(new Font("serif", Font.BOLD, 25));
        graphic.drawString(""+ score,590,30);

        //The Ball
        graphic.setColor(Color.white);
        graphic.fillOval(ballPosX,ballPosY,20,20);

        //Paddle
        graphic.setColor(Color.cyan);
        graphic.fillRect(playerX,550,100,8);
        
        //Game Check
        if(totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            graphic.setColor(Color.white);
            graphic.setFont(new Font("serif",Font.BOLD,30));
            graphic.drawString("You Won!",260,300);

            graphic.setColor(Color.white);
            graphic.setFont(new Font("serif",Font.BOLD,30));
            graphic.drawString("Press (Enter) to restart",230,350);
        }

        if(ballPosY > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            graphic.setColor(Color.red);
            graphic.setFont(new Font("serif",Font.BOLD,30));
            graphic.drawString("Game Over, score: " + score,190,350);

            graphic.setColor(Color.white);
            graphic.setFont(new Font("serif",Font.BOLD,30));
            graphic.drawString("Press (Enter) to restart",230,350);
        }

        graphic.dispose();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        //
        System.out.print("-key pressed");
        if(event.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            System.out.print(" right-");
            pause = false;
            if(playerX >= 600){
                playerX = 600;

            } else {
                moveRight();
            }

        }
        //
        if(event.getKeyCode()== KeyEvent.VK_LEFT)
        {
            System.out.print(" left-");
            pause = false;
            if(playerX < 10){
                playerX = 10;

            } else {
                moveRight();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void moveRight(){
        play = true;
        playerX += 20;
    }

    public void moveLeft(){
        play = true;
        playerX -= 20;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
