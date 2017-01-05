package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by sergeikaganski on 03/01/2017.
 */
public class Stairs extends doorKey{
    int stairsX, stairsY, stairsTileX, stairsTileY;
    public Rectangle stairsUp;

    public Stairs(){
        stairsX=50;
        stairsY=50;
        stairsTileX=11;
        stairsTileY=5;

        stairsUp=new Rectangle( stairsX, stairsY,Color.RED );
    }

    public Rectangle getStairsUp(){
        return stairsUp;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start( primaryStage );
    }


    public int getStairsTileX(){
        return  stairsTileX;
    }
    public int getStairsTileY(){
        return stairsTileY;
    }


}
