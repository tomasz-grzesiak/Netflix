package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.Simulation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartingWindowController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox vBox;

    @FXML
    private HBox hBox1;

    @FXML
    private ImageView imageView;

    @FXML
    private Label label1;

    @FXML
    private HBox hBox2;

    @FXML
    private Label label2;

    @FXML
    private JFXTextField jfxTextFieldDistributors;

    @FXML
    private HBox hBox3;

    @FXML
    private Label label3;

    @FXML
    private JFXTextField jfxTextFieldUsers;

    @FXML
    private HBox hBox4;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private JFXTextField jfxTextFieldProducts;

    @FXML
    private JFXButton jfxButton;

    @FXML
    private void startSimulation() throws IOException {
        for (int i=0; i < Integer.parseInt(jfxTextFieldDistributors.getText()); i++) {
            Simulation.getInstance().createDistributor();
        }
        for (int i=0; i < Integer.parseInt(jfxTextFieldProducts.getText()); i++) {
            Simulation.getInstance().createProduct();
        }
        for (int i=0; i < Integer.parseInt(jfxTextFieldUsers.getText()); i++) {
            Simulation.getInstance().createUser();
        }
        Simulation.getInstance().anchorPane = FXMLLoader.load(getClass().getResource("../fxmls/mainwindow.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scene scene = new Scene(anchorPane);
        Simulation.getInstance().getStage().setScene(scene);
        Simulation.getInstance().getStage().setResizable(false);
        Simulation.getInstance().getStage().show();
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), anchorPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}
