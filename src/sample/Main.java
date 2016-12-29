package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


public class Main extends Application
{
    Stage window;
    Scene sceneIntro;
    public Board board;

    @Override
    public void start(Stage theStage) throws Exception{
        window=theStage;
        board=new  Board();
        //Adding Scene image on second Scene
        Image imageScene = new Image("file:assets/grass.jpeg",600,600, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(imageScene);

        //adding button with image
        Image imageButtonStart = new Image("file:assets/button.png", 50, 30, true, false);
        Button buttonStart=new Button("Start", new ImageView(imageButtonStart));
        buttonStart.setBackground(null); //removing all background of the battle
        //buttonStart.setOnAction(e->); //calling for action, switching between scenes


        //adding shadows to the buttons
        DropShadow shadowStart=new DropShadow();
        buttonStart.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonStart.setEffect(shadowStart);
            }
        });
        buttonStart.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonStart.setEffect(null);
            }
        });

        //buttons location, calculated from center
        buttonStart.setTranslateX(0);
        buttonStart.setTranslateY(30);

        //collectiong all children to Scene
        StackPane layout1 = new StackPane();
        layout1.getChildren().add(imageView);
        layout1.getChildren().add(buttonStart);
        sceneIntro = new Scene(layout1, 600, 600);

        window.setTitle("Demo");
        window.setScene(sceneIntro);
        window.show();





    }



}



