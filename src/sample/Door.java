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

    public Door(){

        doorX=50;
        doorY=50;
        doorTileX=11;
        doorTileY=11;

        Image img = new Image ( "file:assets/door2.png" );
        ImagePattern imagePattern=new ImagePattern( img );

        path=new Rectangle( doorX, doorY, imagePattern );
        path.setId( "exit" );

    }

    public Rectangle getDoor(){
        return path;
    }


    public int getDoorTileX(){
        return  doorTileX;
    }
    public int getDoorTileY(){
        return doorTileY;
    }
}
