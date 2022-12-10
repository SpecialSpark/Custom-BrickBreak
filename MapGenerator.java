import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public int brickNum;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        brickNum = row*col;
        for(int i=0; i<map.length; i += 1){
            for(int j = 0; j < map[0].length; j += 1) {
               
                if((j == 2 || j == 4 ) && i == 1)
                {
                    map[i][j]= 0;
                    brickNum -= 1;
                } else if(i == 0 && (j==0 || j == 6)){
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
    
    brickWidth = 540/col;
    brickHeight = 150/row;

    }
    public int draw(Graphics2D graphic){
        for(int i = 0; i<map.length; i += 1 ){
            for(int j = 0; j<map[0].length; j += 1 ){
                if(map[i][j]>0){
                    graphic.setColor(Color.white);
                    graphic.fillRect(j*brickWidth+80, i * brickHeight + 50, brickWidth, brickHeight);
                    graphic.setStroke(new BasicStroke(3));
                    graphic.setColor(Color.black);
                    graphic.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
        return brickNum;
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
