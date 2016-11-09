package sample.models;

import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.Node;


/**
 * Created by sergeikaganski on 20/10/2016.
 */
public class Gamer extends Application {

    int tileX, tileY;

    public Rectangle gamer;

    @Override
    public void start(Stage primaryStage) throws Exception {


    }


    public Gamer() {

       // Image img = new Image ( "file:assets/hero.jpg" );
       // ImagePattern hero=new ImagePattern( img );


        tileX=1;
        tileY=1;

        Rectangle gamer= new Rectangle( 50, 50 );
        gamer.setFill( Color.GREEN );




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
    public void move(int dx, int dy){

        tileX=tileX+dx;
        tileY=tileY+dy;


    }
}




