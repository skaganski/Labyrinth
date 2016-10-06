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
    Scene sceneGame;


    public static void main(String[] args)
    {

        launch(args);
    }


    @Override
    public void start(Stage theStage) throws Exception{
        window=theStage;
        Image imageScene = new Image("file:assets/grass.jpeg",600,400, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(imageScene);

        Image imageGame=new Image("file:assets/labyr.png",600,400, false, false);
        ImageView imageView2=new ImageView();
        imageView2.setImage(imageGame);


        Image imageButtonStart = new Image("file:assets/button.png", 50, 30, true, false);
        Button buttonStart=new Button("Start", new ImageView(imageButtonStart));
        buttonStart.setOnAction(e->window.setScene(sceneGame));



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

        buttonStart.setTranslateX(0);
        buttonStart.setTranslateY(30);

        StackPane layout1 = new StackPane();
        layout1.getChildren().add(imageView);
        layout1.getChildren().add(buttonStart);
        sceneIntro = new Scene(layout1, 600, 400);


        Button buttonSwitch=new Button("Back");

        buttonSwitch.setTranslateX(270);
        buttonSwitch.setTranslateY(-170);
        buttonSwitch.setOnAction(e-> window.setScene(sceneIntro));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(imageView2);
        layout2.getChildren().add(buttonSwitch);
        sceneGame = new Scene(layout2, 600, 400);



        window.setTitle("Demo");
        window.setScene(sceneIntro);
        window.show();





    }



}



