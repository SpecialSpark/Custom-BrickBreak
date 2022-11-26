import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private MapGenerator map;
    private Timer timer;
    private int playerX = 310;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int delay = 8;

    public GamePlay () {
        map = new MapGenerator(4,12);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics graphic) {
        
        //Background
        graphic.setColor(Color.cyan);
        graphic.fillRect(1,1,692,592);

        //Drawing map
        map.draw((Graphics2D) graphic);

        //Setting Borders
        graphic.setColor(Color.cyan);
        graphic.fillRect(0,0,3,592);
        graphic.fillRect(0,0,692,3);
        graphic.fillRect(691,0,3,592);

        //Scores
        graphic.setColor(Color.white);
        graphic.fillOval(ballPosX,ballPosY,20,20);

        //Paddle
        graphic.setColor(Color.cyan);
        graphic.fillRect(playerX,550,100,8);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
