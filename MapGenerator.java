import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    
    public MapGenerator(int row, int col) {
        map = new int[row][col];

        for(int i=0; i<map.length; i += 1){
            for(int j = 0; j < map[0].length; j += 1) {
                map[i][j]=1;
            }
        }
    
    brickWidth = 540/col;
    brickHeight = 150/row;

    }
    public void draw(Graphics2D graphic){
        for(int i = 0; i<map.length;i+=1){
            for(int j = 0; j<map.length; j += 1){
                if(map[i][j]>0){
                    graphic.setColor(Color.white);
                    graphic.fillRect(j*brickWidth+80, i * brickHeight + 50, brickWidth, brickHeight);
                    graphic.setStroke(new BasicStroke(3));
                    graphic.setColor(Color.black);
                    graphic.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
