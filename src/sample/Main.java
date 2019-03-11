package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Simulation.getInstance();
        FXMLLoader.load(getClass().getResource("../fxmls/loadingScreen.fxml"));

    }

    public static void main(String[] args) {
        launch(args);
    }

}