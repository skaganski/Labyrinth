package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.models.Gamer;

/**
 * Created by sergeikaganski on 28/12/2016.
 */
public class Minotaurus extends Gamer{

    int minoX, minoY, minoTileX, minoTileY;
    Rectangle enemy;

    public Minotaurus(){
        minoX=50;
        minoY=50;
        minoTileX=1;
        minoTileY=9;

        enemy=new Rectangle( minoX, minoY, Color.BLACK );


    }

    public Rectangle getEnemy(){
        return enemy;
    }

    public int getMinoX(){return minoX;}
    public int getMinoY(){return minoY;}
    public int getMinoTileX(){return  minoTileX;}
    public int getMinoTileY(){return  minoTileY;}

    public void move(int minoDx, int minoDy, int tileDx, int tileDy){
        minoX+=minoDx;
        minoY+=minoDy;
        minoTileX+=tileDx;
        minoTileY+=tileDy;

    }

}
