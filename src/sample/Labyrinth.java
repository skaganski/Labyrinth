package sample;


import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.*;
import javafx.scene.image.Image;
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
    public static int mapLengthTiles = 13;
    public static int tilesizePx = 50;
    private static Rectangle player = new Rectangle( tilesizePx, tilesizePx );

    public static int [][] labyrinth=new int[13][13];


    public Rectangle tile;
    public Rectangle block=new Rectangle( tilesizePx, tilesizePx );
    public static Rectangle tile2;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int value = 1;
    public int locationX=0;
    public static int locationY=0;



    public static boolean goNorth, goSouth, goEast, goWest;





    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );


    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene2();
        //addTiles();
        //canMoveLeft();
        //generateMap();


    }

    public void mapScene2() {

        tileMap = new GridPane();
        Stage stage = new Stage();
        Scene scene = new Scene( tileMap, mapLengthTiles * tilesizePx, mapLengthTiles * tilesizePx );
        addTiles();



        scene.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                    case LEFT: {
                        int[][] labyrinth = new int[][]
                                {
                                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                        {1, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
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
                            System.out.print(labyrinth);
                        //locationX=locationX-1;
                        System.out.println(tileMap.getRowIndex( player ));
                        System.out.println(tileMap.getColumnIndex( player ));
                        System.out.println(tileMap.getColumnIndex( block ));
                        System.out.println(tileMap.getRowIndex( block ));

                        if(tileMap.getRowIndex( player )==tileMap.getRowIndex(block) &&
                               tileMap.getColumnIndex( player )-1==tileMap.getColumnIndex( block )){
                            System.out.print("HUI");
                            break;
                        }

                       if (tileMap.getColumnIndex( player ) > 1) {
                        locationX=locationX-1;
                           tileMap.setColumnIndex( player, locationX );
                                  System.out.println( "polozenije" + tileMap.getColumnIndex( player ) );
                       }

                        System.out.println( "Move left" );
                       break;
                    }
                    case W:
                    case UP: {
                        locationY=locationY-1;
                               if (tileMap.getRowIndex( player )>1 ) {
                                   tileMap.setRowIndex( player, locationY );
                        }
                        System.out.println( "Move up" );
                        break;
                    }
                    case D:
                    case RIGHT: {
                            locationX=locationX+1;

                               if (tileMap.getColumnIndex( player )<11){
                                   tileMap.setColumnIndex(player, locationX);
                       }
                        System.out.println( "Move right" );
                        break;
                    }
                    case S:
                    case DOWN: {

                        locationY=locationY+1;

                                if (tileMap.getRowIndex(player)<11) {

                                    tileMap.setRowIndex(player, locationY);
                                    System.out.println("DOWN");
                                }
                         System.out.println( "Move down" );
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


    public  void addTiles() {

        int[][] labyrinth = new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
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

                } else {

                    Rectangle Hero = new Rectangle( tilesizePx, tilesizePx );
                    Hero.setFill( Color.GREEN );
                    tileMap.add( Hero, count1, count2 );
                    Hero.setId( "Hero" );

                }
            }


        }

        tileMap.setRowIndex( player, 1 );
        tileMap.setColumnIndex( player,1 );
        player.setId("Hero");
        tileMap.getChildren().add(player);
        tileMap.setRowIndex( block, 4 );
        tileMap.setColumnIndex( block,4 );
        player.setId("block");
        tileMap.getChildren().add(block);



    }

 //   public Node getPlayer(GridPane tileMap, int col, int row) {
   //    for (Node player : tileMap.getChildren()){
     //     if (GridPane.getColumnIndex( player )==value && GridPane.getRowIndex(player)==value){
//
//
  //            System.out.print(locationY);
    //            return player;


      //     }
       //}

      //return  null;
   //}







   // static boolean canMoveLeft() {
     //  for(int count1=0; count1<mapLengthTiles; count1++)
       //{
         // for(int count2=0; count2<mapLengthTiles-1; count2++)
           //{
            //if (labyrinth[count1][count2] == labyrinth[count1][count2+1] && labyrinth[count1][count2]!=0) {
              //return true;
              //}
              //if (labyrinth[count1][count2+1]!=0 && labyrinth[count1][count2]==0) {
                //   return true;
               //}
            //}
       //}
       //return false;
    //}
}














