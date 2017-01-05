package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.models.Gamer;

/*
 * Created by sergeikaganski on 08/10/2016.
 */
public class Board extends Application {
    public Door door;
    public Gamer hero;
    public doorKey exitKey;
    public doorKey2 exitKey2;
    public Stairs stairs;
    public static void main(String[] args) {
        launch( args );
    }
    public static GridPane tileMap;
    public static int mapLengthTiles = 13;
    public static int tilesizePx = 50;
    static int[][] labyrinth;
    static int[][] labyrinth2;
    Rectangle tile;
    Rectangle tile2;
    Scene scene;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int value = 1;
    boolean firstLevel=true;


    Image rocks = new Image( "file:assets/rocks.jpg" );
    ImagePattern wall = new ImagePattern( rocks );
    Image path = new Image( "file:assets/road.jpg" );
    ImagePattern road = new ImagePattern( path );

    @Override
    public void start(Stage primaryStage) throws Exception {
        mapScene();
        mazeMap();
        addToMap();
        keyMoving();
    }

    public void mapScene() {

            tileMap = new GridPane();
            Stage stage = new Stage();
            scene = new Scene( tileMap, mapLengthTiles * tilesizePx, mapLengthTiles * tilesizePx );
            stage.setScene( scene );
            stage.show();
    }

    public void closeStage(){
        scene.getWindow().hide();
    }

    public void addToMap(){

        stairs=new Stairs();
        hero=new Gamer();
        exitKey=new doorKey();
        door=new Door();
        exitKey2=new doorKey2();
        tileMap.add(hero.getPlayer(), hero.getTileY(),hero.getTileX());
        tileMap.add(exitKey.getDoorKey(), exitKey.getKeyTileY(), exitKey.getKeyTileX());
    }

    public void addToMap2(){

        addToMap();
        tileMap.add(exitKey2.getDoorKey(), exitKey2.getKeyTileY(), exitKey2.getKeyTileX());
    }

    public boolean checklLevel(){
        if(firstLevel){
            return true;

        }else{

        return false;
    }}
    public void chooseLevel(){
    if(checklLevel()){
        stairsAppear();
        }else{
        doorAppear();
        System.out.print(firstLevel);
    }
    }


    public void keyMoving(){
        scene.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case A:
                    case LEFT: {

                        if(getNodeFromGridPane( tileMap, hero.getTileY()-1, hero.getTileX() ).getId().equals( "tee" )) {
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( 0, 50, 0, -1 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                            keyCollected();
                            chooseLevel();
                            nextLevel();
                            gameOver();

                        }

                        System.out.print( "Move left" );
                        System.out.println();
                        break;
                    }
                    case W:
                    case UP: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()-1 ).getId().equals( "tee" )) {
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( -50, 0, -1, 0 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                            keyCollected();
                            chooseLevel();
                            nextLevel();
                            gameOver();
                        }
                        System.out.print( "Move Up" );
                        System.out.println();
                        break;
                    }
                    case D:
                    case RIGHT: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY()+1, hero.getTileX() ).getId().equals( "tee" )) {
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( 0, 50, 0, 1 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                            keyCollected();
                            chooseLevel();
                            nextLevel();
                            gameOver();
                        }

                        System.out.print( "Move right" );
                        System.out.println();
                        break;
                    }
                    case S:
                    case DOWN: {
                        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()+1 ).getId().equals( "tee" )) {
                            tileMap.getChildren().removeAll( hero.getPlayer() );
                            hero.move( 50, 0, 1, 0 );
                            tileMap.add( hero.getPlayer(), hero.getTileY(), hero.getTileX() );
                            keyCollected();
                            chooseLevel();
                            nextLevel();
                            gameOver();
                        }
                        System.out.print( "Move down" );
                        System.out.println();
                        break;
                    }
                    default:
                        break;
                }
            }
        } );
    }


    public  void mazeMap(){
            labyrinth = new int[][]
                    {
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                            {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                    };
        for (count1 = 0; count1 < mapLengthTiles; count1++) {
            for (count2 = 0; count2 < mapLengthTiles; count2++) {

                if (labyrinth[count1][count2] == value) {

                    tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( wall );
                    tileMap.add( tile, count2, count1 );
                    tile.setId("sein");


                } else if (labyrinth[count1][count2]!=value) {
                    tile2 = new Rectangle( tilesizePx, tilesizePx );
                    tile2.setFill( road );
                    tileMap.add( tile2, count2, count1 );
                    tile2.setId( "tee" );

                }
            }
        }

    }
    public void mazeMap2(){
        labyrinth2=new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                        {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
        for (count1 = 0; count1 < mapLengthTiles; count1++) {
            for (count2 = 0; count2 < mapLengthTiles; count2++) {

                if (labyrinth2[count1][count2] == value) {

                    tile = new Rectangle( tilesizePx, tilesizePx );
                    tile.setFill( wall );
                    tileMap.add( tile, count2, count1 );
                    tile.setId("sein");


                } else if (labyrinth2[count1][count2]!=value) {
                    tile2 = new Rectangle( tilesizePx, tilesizePx );
                    tile2.setFill( road );
                    tileMap.add( tile2, count2, count1 );
                    tile2.setId( "tee" );

                }
            }
        }

    }

    //http://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void gameOver(){

        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()) ==
        getNodeFromGridPane( tileMap, door.getDoorTileY(), door.getDoorTileX() ) &&
                tileMap.getChildren().contains( door.getDoor() )){

            System.out.print( "Winner!" );
            StackPane stack = new StackPane();
            Label message = new Label( "Winner! \nGame Over" );
            message.setFont( Font.font( "Verdana", 32 ) );
            message.setTextFill( Color.ORANGE );
            stack.getChildren().add( message );
            stack.setBackground( new Background( new BackgroundFill(
                    Color.DARKGREEN,
                    CornerRadii.EMPTY,
                    Insets.EMPTY ) ) );
            scene.setRoot( stack );
        }
    }
    // key collecting, if collected, then remove from Grid
    public void keyCollected(){

            if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() ) ==
                    getNodeFromGridPane( tileMap, exitKey.getKeyTileY(), exitKey.getKeyTileX() ) ){
                tileMap.getChildren().remove( exitKey.getDoorKey() );
                tileMap.getChildren().remove( stairs.getStairsUp() );
                System.out.print("collected");
            }else if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX() )==
                    getNodeFromGridPane( tileMap, exitKey2.getKeyTileY(), exitKey2.getKeyTileX() )){
                tileMap.getChildren().remove( exitKey2.getDoorKey() );
                tileMap.getChildren().remove( stairs.getStairsUp() );
            }
    }

    public  void doorAppear(){

        //if contains, then do nothing
        if(tileMap.getChildren().contains( exitKey.getDoorKey()) ||tileMap.getChildren().contains( exitKey2.getDoorKey() )){

        } else if(tileMap.getChildren().contains(door.getDoor() ) ) {

        }
        else{

            tileMap.add(door.getDoor(), door.getDoorTileY(), door.getDoorTileX());
        }
    }

    public void stairsAppear(){
        if(tileMap.getChildren().contains( exitKey2.getDoorKey()) || tileMap.getChildren().contains( exitKey.getDoorKey() ) ){
            // to eliminate duplicates
        } else if(tileMap.getChildren().contains( stairs.getStairsUp())) {

        }
        else{
            tileMap.add(stairs.getStairsUp(), stairs.getStairsTileY(), stairs.getStairsTileX());
        }
    }

    public void nextLevel(){

        if(getNodeFromGridPane( tileMap, hero.getTileY(), hero.getTileX()) ==
                getNodeFromGridPane( tileMap, stairs.getStairsTileY(), stairs.getStairsTileX() ) &&
                tileMap.getChildren().contains( stairs.getStairsUp() ) )
        {
            firstLevel=false;
            closeStage();
            mapScene();
            mazeMap2();
            addToMap2();
            keyMoving();
        }
    }

}















