package crawler.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the initial scene with Object A information
        StackPane objectAPane = new StackPane();
        Label objectALabel = new Label("Object A");
        objectAPane.getChildren().add(objectALabel);
        Scene scene = new Scene(objectAPane, 800, 600);

        // Handle the click event on Object A
        objectAPane.setOnMouseClicked(event -> {
            // Create the scene for Object B information
            StackPane objectBPane = new StackPane();
            Label objectBLabel = new Label("Object B");
            objectBPane.getChildren().add(objectBLabel);
            Scene objectBScene = new Scene(objectBPane, 800, 600);

            // Set the Object B scene as the active scene
            primaryStage.setScene(objectBScene);
        });

        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

