package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Node;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.models.Player;


/*
 * Created by sergeikaganski on 08/10/2016.
 */
public class Labyrinth extends Application {
    public static void main(String[] args) {
        launch( args );
    }

    public static GridPane tileMap;
    static int mapLengthTiles = 13;
    static int tilesizePx = 50;
    final static Rectangle player = new Rectangle( 40, 40 );
    private static int [][] labyrinth=new int[13][13];



    public static int count1 = 0;
    public static int count2 = 0;
    public static int value = 1;
    public static int locationX=0;
    public static int locationY=0;


    public static boolean goNorth, goSouth, goEast, goWest;





    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );


    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene2();
        addTiles();
        canMoveLeft();

        //();



    }




    public static void mapScene2() {

        tileMap = new GridPane();
        Stage stage = new Stage();
        Scene scene = new Scene( tileMap, mapLengthTiles * tilesizePx, mapLengthTiles * tilesizePx );
        //stage.setScene( scene );
        //stage.show();
        //Thread.sleep(5000);-paneb programmi seisma 5 sekundiks

        scene.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                    case LEFT: {
                        locationY=locationY-1;
                        for(count1=0; count1<mapLengthTiles; count1++) {
                            for (count2 = 0; count2 < mapLengthTiles; count2++) {


                                if (labyrinth[count1][count2]!=value) {


                                   System.out.println( locationY );
                                   tileMap.setColumnIndex(player, locationY);
                                    System.out.println("Left");


                                } else {
                                    player.setFill(Color.ORANGE);
                                    break;

                                }
                            }
                        }

                        System.out.println( "Move left" );
                        break;
                    }
                    case W:
                    case UP: {
                        locationX=locationX-1;
                        for(count1=0; count1<mapLengthTiles; count1++) {
                            for (count2 = 0; count2 < mapLengthTiles; count2++) {


                                if (labyrinth[count1][count2]!=value) {


                                    System.out.println( locationX );
                                    tileMap.setRowIndex(player, locationX);
                                    System.out.println("UP");


                                } else {
                                    player.setFill( Color.ORANGE);
                                    System.out.println("Can't move");
                                    break;

                                }
                            }
                        }


                        System.out.println( "Move up" );
                        break;
                    }

                    case D:
                    case RIGHT: {
                            locationY=locationY+1;
                       for(count1=0; count1<mapLengthTiles; count1++) {
                           for (count2 = 0; count2 < mapLengthTiles; count2++) {


                               if (labyrinth[count1][count2] != value) {

                                   System.out.println( locationY );
                                   tileMap.setColumnIndex(player, locationY);
                                   System.out.println("Right");


                               } else {
                                    break;

                               }
                           }
                       }



                        System.out.println( "Move right" );
                        break;
                    }
                    case S:
                    case DOWN: {

                        locationX=locationX+1;
                        for(count1=0; count1<mapLengthTiles; count1++) {
                            for (count2 = 0; count2 < mapLengthTiles; count2++) {


                                if (labyrinth[count1][count2] != value) {


                                    System.out.println( locationX );
                                    tileMap.setRowIndex(player, locationX);
                                    System.out.println("DOWN");


                                } else {
                                    System.out.println("Can't move");
                                    break;

                                }
                            }
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


    public void addTiles() {

        int[][] labyrinth = new int[][]
                {
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
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
                    tile.setId("sein");

                } else if (labyrinth[count1][count2] != value) {
                    Rectangle tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( road );
                    tileMap.add( tile, count1, count2 );
                    tile.setId("tee");

                }


            }


        }


        tileMap.setRowIndex( player, locationX );
        tileMap.setColumnIndex( player,locationY );
        tileMap.getChildren().add(player);





    }



    public Node getPlayer(GridPane tileMap, int col, int row) {
       for (Node player : tileMap.getChildren()){
          if (GridPane.getColumnIndex( player )==col && GridPane.getRowIndex(player)==row){


              System.out.print(locationY);
                return player;


           }
       }

      return  null;
   }







    private boolean canMoveLeft() {
       for(int count1=0; count1<mapLengthTiles; count1++)
       {
          for(int count2=0; count2<mapLengthTiles-1; count2++)
           {
            if (labyrinth[count1][count2] == labyrinth[count1][count2+1] && labyrinth[count1][count2]!=0) {
              return true;
              }
              if (labyrinth[count1][count2+1]!=0 && labyrinth[count1][count2]==0) {
                   return true;
               }
            }
       }
       return false;
    }
}














