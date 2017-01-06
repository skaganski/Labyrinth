package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by sergeikaganski on 25/12/2016.
 */
public class Door extends Application {
    int doorX, doorY, doorTileX, doorTileY;
    Rectangle path;
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    //locating door on gridpane
    public Door(){

        doorX=50; // width in ix
        doorY=50; // heigth in pix
        doorTileX=11; // position by x
        doorTileY=11; // position by y
        //adding image
        Image img = new Image ( "file:assets/door2.png" );
        ImagePattern imagePattern=new ImagePattern( img );

        path=new Rectangle( doorX, doorY, imagePattern );
        path.setId( "exit" );

    }
    // method to get player
    public Rectangle getDoor(){
        return path;
    }

    //method to get position by x and  y
    public int getDoorTileX(){
        return  doorTileX;
    }
    public int getDoorTileY(){
        return doorTileY;
    }
}
