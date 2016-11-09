package sample;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.models.Gamer;



/*
 * Created by sergeikaganski on 08/10/2016.
 */
public class Board extends Application {


    public static void main(String[] args) {
        launch( args );
    }

    public static GridPane tileMap;
    public static int mapLengthTiles = 13;
    public static int tilesizePx = 50;


    public static int [][] labyrinth=new int[13][13];

    public static int count1 = 0;
    public static int count2 = 0;
    public static int value = 1;


    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );
    Gamer hero=new Gamer();

    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene2();
        addTiles();

        System.out.print(hero.getPlayer());
        System.out.print(hero.getTileX());

        tileMap.add(hero.getPlayer(), hero.getTileX(),hero.getTileY());
    }

    public void mapScene2() {


        tileMap = new GridPane();
        Stage stage = new Stage();
        Scene scene = new Scene( tileMap, mapLengthTiles * tilesizePx, mapLengthTiles * tilesizePx );




        scene.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                    case LEFT: {


                        hero.move( 0, -1 );


                        System.out.println( "Move left" );
                        break;
                    }
                    case W:
                    case UP: {
                        hero.move(0, -1);
                    }
                    case D:
                    case RIGHT: {
                        hero.move(1, 0);
                    }
                    case S:
                    case DOWN: {
                        hero.move(0, 1);
                    }
                    default:
                        break;
                }
            }
        } );
        stage.setScene( scene );
        stage.show();
    }


    public  void addTiles() {

        int[][] labyrinth = new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };


        for (count1 = 0; count1 < mapLengthTiles; count1++) {
            for (count2 = 0; count2 < mapLengthTiles; count2++) {

                if (labyrinth[count1][count2] == value) {

                    Rectangle tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( wall );
                    tileMap.add( tile, count1, count2 );
                    tile.setId("sein");


                } else if (labyrinth[count1][count2] != value && labyrinth[count1][count2]!=2) {
                    Rectangle tile2 = new Rectangle( tilesizePx, tilesizePx );
                    tile2.setFill( road );
                    tileMap.add( tile2, count1, count2 );
                    tile2.setId( "tee" );

                }


            }


        }

        //tileMap.add(hero.getPlayer(), hero.getTileX(), hero.getTileY());


    }

}














