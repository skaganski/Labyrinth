package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by sergeikaganski on 25/12/2016.
 */
public class doorKey extends Application {
    int keyX, keyY, keyTileX, keyTileY;
    public Rectangle doorKey;

    @Override
    public void start(Stage primaryStage) throws Exception {


    }

    public doorKey() {

        Image img = new Image ( "file:assets/doorkey.png" );
        ImagePattern imagePattern=new ImagePattern( img );
        keyX=50;
        keyY=50;
        keyTileX=5;
        keyTileY=5;
        doorKey = new Rectangle( keyX, keyY, imagePattern );
        doorKey.setId( "key" );
    }

    public Rectangle getDoorKey(){
        return doorKey;
    }
    public int getX(){
        return  keyX;
    }
    public int getY(){
        return keyY;
    }
    public int getKeyTileX(){
        return keyTileX;
    }
    public int getKeyTileY(){
        return keyTileY;
    }

}
