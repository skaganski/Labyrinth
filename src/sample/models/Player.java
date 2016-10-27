package sample.models;

import javafx.application.Application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Labyrinth;

import static sample.Labyrinth.tileMap;

/**
 * Created by sergeikaganski on 20/10/2016.
 */
public class Player extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       // addPlayer();
        Labyrinth lab=new Labyrinth();
        lab.start( primaryStage );

    }



    //public void addPlayer() {
        //Rectangle player=new Rectangle( 50, 50 );
       // player.setFill( Color.GREEN );
       // tileMap.add(player, 0, 10);

    }




