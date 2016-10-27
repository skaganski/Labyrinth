package sample;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




/*
 * Created by sergeikaganski on 08/10/2016.
 */
public class Labyrinth extends Application {
    public static void main(String[] args) {
        launch( args );
    }

    public static GridPane tileMap;
    static int mapLengthTiles = 11;
    static int tilesizePx = 50;
    final Rectangle player = new Rectangle( 40, 40 );
    public static Scene scene;



    int count1 = 0;
    int count2 = 0;
    int value = 1;
    int locationX=0;
    int locationY=0;



    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );


    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene2();
        addTiles();
        moveOnKeyPressed( tileMap, player );


    }




    public static void mapScene2() {

        tileMap = new GridPane();
        Stage stage = new Stage();
        Scene scene = new Scene( tileMap, mapLengthTiles * tilesizePx, mapLengthTiles * tilesizePx );
        stage.setScene( scene );
        stage.show();


    }


    public void addTiles() {

        int[][] labyrinth = new int[][]
                {
                        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0}
                };
        //int count=0;

        //while(count<11) {
        // System.out.println( Arrays.toString(labyrinth[count]) );
        // count++;
        // }


        for (count1 = 0; count1 < mapLengthTiles; count1++) {
            for (count2 = 0; count2 < mapLengthTiles; count2++) {
                if (labyrinth[count1][count2] == value) {
                    Rectangle tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( wall );
                    tileMap.add( tile, count1, count2 );

                } else if (labyrinth[count1][count2] != value) {
                    Rectangle tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( road );
                    tileMap.add( tile, count1, count2 );

                }


            }


        }


        player.setFill( Color.BLACK );
        tileMap.add( player, 0,9);




    }




    private Node getNode(GridPane tileMap, int col, int row) {
        for (Node node : tileMap.getChildren()){
            if (GridPane.getColumnIndex( node )==col && GridPane.getRowIndex(node)==row){
                return node;
                //System.out.println();
            }
        }
        return  null;
    }



    private void moveOnKeyPressed(GridPane tileMap, Rectangle player) {
        tileMap.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode())
                {
                    case A: player.setTranslateX( player.getTranslateX()+tilesizePx ); break;


                }
            }
        } );
    }

}














