package controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.Simulation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreenController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scene scene = new Scene(pane);
        Simulation.getInstance().getStage().setScene(scene);
        Simulation.getInstance().getStage().show();
        Simulation.getInstance().getStage().setTitle("Nietflix © by Sid");
        Simulation.getInstance().getStage().setResizable(false);
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), label);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        FadeTransition fadeOut = new FadeTransition(Duration.millis(2000), label);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeIn.setOnFinished(event -> fadeOut.play());
        fadeOut.setOnFinished(event -> {
            try {
                FXMLLoader.load(getClass().getResource("../fxmls/startingWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
