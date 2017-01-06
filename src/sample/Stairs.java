package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
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
        Image img = new Image ( "file:assets/portal.jpg" );
        ImagePattern imagePattern=new ImagePattern( img );
        stairsUp=new Rectangle( stairsX, stairsY,imagePattern );
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
