package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by sergeikaganski on 25/12/2016.
 */
public class doorKey2 extends doorKey {
    int keyX, keyY, keyTileX, keyTileY;
    public Rectangle doorKey2;


    public doorKey2(){
        Image img = new Image ( "file:assets/doorkey.png" );
        ImagePattern imagePattern=new ImagePattern( img );
        keyX=50;
        keyY=50;
        keyTileX=8;
        keyTileY=8;
        doorKey2 = new Rectangle( keyX, keyY, imagePattern );
        doorKey2.setId( "key" );
    }
    @Override
    public Rectangle getDoorKey() {
        return super.getDoorKey();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start( primaryStage );
    }

    @Override
    public int getKeyTileX() {
        return keyTileX;
    }

    @Override
    public int getKeyTileY() {
        return keyTileY;
    }
}
