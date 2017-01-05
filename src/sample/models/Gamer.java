package sample.models;

import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




/**
 * Created by sergeikaganski on 20/10/2016.
 */
public class Gamer extends Application  {

    int x, y,tileX, tileY;


    public Rectangle gamer;
    @Override
    public void start(Stage primaryStage) throws Exception {


    }


    public Gamer() {

       Image img = new Image ( "file:assets/hero2.png" );
       ImagePattern imagePattern=new ImagePattern( img );

        x=50;
        y=50;
        tileX=1;
        tileY=1;

        gamer=new Rectangle( x, y, imagePattern );

    }
    public Rectangle getPlayer(){


        return gamer;

    }

    public int getTileX(){
        return  tileX;
    }
    public int getTileY(){
        return tileY;
    }

    public void move(int dx, int dy, int tx, int ty){

        x+=dx;
        y+=dy;
        tileX+=tx;
        tileY+=ty;


    }
}




