import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePlay gameplay = new GamePlay();

        frame.setBounds(500,100,700,600);
        frame.setTitle("Break Bricks");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
        frame.setVisible(true);
    }
}