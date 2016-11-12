package sample;



import javafx.application.Application;
import javafx.collections.ObservableList;
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

    public Gamer hero;
    public static void main(String[] args) {
        launch( args );
    }
    public static GridPane tileMap;
    public static int mapLengthTiles = 13;
    public static int tilesizePx = 50;
    int[][] labyrinth;
    Rectangle tile;
    Rectangle tile2;


    public static int count1 = 0;
    public static int count2 = 0;
    public static int value = 1;


    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );


    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene2();
        addTiles();
        hero=new Gamer();
        tileMap.add(hero.getPlayer(), hero.getTileY(),hero.getTileX());


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

                                if(getNodeFromGridPane( tileMap, hero.getTileY()-1, hero.getTileX() ).getId().equals( "tee" )) {
                                    System.out.print( getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() - 1 ).getId() );
                                    System.out.println();
                                    tileMap.getChildren().removeAll( hero.getPlayer() );
                                    hero.move( 0, 50, 0, -1 );

                                    tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                                }
                        System.out.print( "Move left" );
                        break;
                    }
                    case W:
                    case UP: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()-1 ).getId().equals( "tee" )) {
                            System.out.print( getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() ) );
                            System.out.println();
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( -50, 0, -1, 0 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                        }
                        System.out.print( "Move Up" );
                        break;
                    }
                    case D:
                    case RIGHT: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY()+1, hero.getTileX() ).getId().equals( "tee" )) {
                            System.out.print( getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() ) );
                            System.out.println();
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( 0, 50, 0, 1 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                        }
                        System.out.print( "Move right" );
                        break;
                    }
                    case S:
                    case DOWN: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()+1 ).getId().equals( "tee" )) {
                            System.out.print( getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() ) );
                            System.out.println();
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( 50, 0, 1, 0 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                        }
                        System.out.print( "Move down" );
                        break;
                    }
                    default:
                        break;
                }
            }
        } );
        stage.setScene( scene );
        stage.show();
    }


    public void  addTiles() {


        labyrinth = new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };


        for (count1 = 0; count1 < mapLengthTiles; count1++) {
            for (count2 = 0; count2 < mapLengthTiles; count2++) {

                if (labyrinth[count1][count2] == value) {

                    tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( wall );
                    tileMap.add( tile, count2, count1 );
                    tile.setId("sein");


                } else if (labyrinth[count1][count2] != value) {
                    tile2 = new Rectangle( tilesizePx, tilesizePx );
                    tile2.setFill( road );
                    tileMap.add( tile2, count2, count1 );
                    tile2.setId( "tee" );

                }


            }


        }

    }
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

}














