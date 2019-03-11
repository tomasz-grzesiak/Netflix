package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;


public class MainWindowController implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private VBox vBox1;

    @FXML
    private HBox hBox1;

    @FXML
    private ImageView imageViev;

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private VBox vBox2;

    @FXML
    private Label label1;

    @FXML
    private Label accountLabel;

    @FXML
    private Label label2;

    @FXML
    private Label daysCounterLabel;

    @FXML
    private JFXButton buttonController;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Tab productsTab;

    @FXML
    private AnchorPane productsTabAnchorPane;

    @FXML
    private TableView productsTabTableView;

    @FXML
    private TableColumn productsTabColumnType;

    @FXML
    private TableColumn productsTabColumnTitle;

    @FXML
    private TableColumn productsTabColumnCountries;

    @FXML
    private TableColumn productsTabColumnNote;

    @FXML
    private TableColumn productsTabColumnPrice;

    @FXML
    private Tab usersTab;

    @FXML
    private AnchorPane usersTabAnchorPane;

    @FXML
    private TableView usersTabTableView;

    @FXML
    private TableColumn usersTabColumnName;

    @FXML
    private TableColumn usersTabColumnAdress;

    @FXML
    private TableColumn usersTabColumnCardNumber;

    @FXML
    private TableColumn usersTabColumnSubscription;

    @FXML
    private Tab distributorsTab;

    @FXML
    private AnchorPane distributorsTabAnchorPane;

    @FXML
    private TableView distributorsTabTableView;

    @FXML
    private TableColumn distributorsTabColumnId;

    @FXML
    private TableColumn distributorsTabColumnMonthly;

    @FXML
    private TableColumn distributorsTabColumnPercent;

    @FXML
    private Label label3;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private VBox vBox3;

    @FXML
    private HBox hBox2;

    @FXML
    private VBox vBox4;

    @FXML
    private Label label4;

    @FXML
    private Label firstMonthLabel;

    @FXML
    private VBox vBox5;

    @FXML
    private Label label5;

    @FXML
    private Label secondMonthLabel;

    @FXML
    private VBox vBox6;

    @FXML
    private Label label6;

    @FXML
    private Label thirdMonthLabel;

    @FXML
    private HBox hBox3;

    @FXML
    private Label label7;

    @FXML
    private Label productsLabel;

    @FXML
    private JFXButton buttonProduts;

    @FXML
    private HBox hBox4;

    @FXML
    private Label label8;

    @FXML
    private Label usersLabel;

    @FXML
    private JFXButton buttonUsers;

    @FXML
    private HBox hBox5;

    @FXML
    private Label label9;

    @FXML
    private Label distributorsLabel;

    @FXML
    private JFXButton buttonDistributors;

    @FXML
    private void showHideController() {
        if(mainAnchorPane.getWidth() < 750) {
            Simulation.getInstance().getStage().setWidth(900.0);
        }
        else {
            Simulation.getInstance().getStage().setWidth(600.0);
        }

    }

    @FXML
    private void startStop() throws InterruptedException {
        if(Simulation.getInstance().isRunning()) {
            System.out.println("Wyłączam symulację...");
            Simulation.getInstance().setRunning(false);
            toggleButton.setText("Kontynuuj symulację");
            for (Distributor i:Simulation.getInstance().getDistributors()) {
                i.setRunning(false);
            }
            for (User i:Simulation.getInstance().getUsers()) {
                i.setRunning(false);
            }
            Simulation.getInstance().getExecutor().shutdown();
        }
        else {
            Simulation.getInstance().setRunning(true);
            System.out.println("Włączam symulację...");
            Simulation.getInstance().setExecutor((ThreadPoolExecutor) Executors.newFixedThreadPool(500));
            toggleButton.setText("Przerwij symulację");
            for (Distributor i : Simulation.getInstance().getDistributors()) {
                i.setRunning(true);
                Simulation.getInstance().getExecutor().execute(i);
            }
            for (User i:Simulation.getInstance().getUsers()) {
                i.setRunning(true);
                Simulation.getInstance().getExecutor().execute(i);
            }
        }
    }



    @FXML
    public void createDistributor() {
        Simulation.getInstance().createDistributor();
    }

    @FXML
    public void createProduct() {
        Simulation.getInstance().createProduct();
    }

    @FXML
    public void createUser() {
        Simulation.getInstance().createUser();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scene scene = new Scene(mainAnchorPane);
        Simulation.getInstance().getStage().setScene(scene);
        productsTabColumnType.setCellValueFactory(new PropertyValueFactory<>("entityType"));
        productsTabColumnTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        productsTabColumnCountries.setCellValueFactory(new PropertyValueFactory<>("countriesString"));
        productsTabColumnNote.setCellValueFactory(new PropertyValueFactory<>("note"));
        productsTabColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        usersTabColumnName.setCellValueFactory(new PropertyValueFactory<>("userId"));
        usersTabColumnAdress.setCellValueFactory(new PropertyValueFactory<>("email"));
        usersTabColumnCardNumber.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        usersTabColumnSubscription.setCellValueFactory(new PropertyValueFactory<>("subscriptionType"));
        distributorsTabColumnId.setCellValueFactory(new PropertyValueFactory<>("distributorId"));
        distributorsTabColumnMonthly.setCellValueFactory(new PropertyValueFactory<>("contractValue"));
        distributorsTabColumnPercent.setCellValueFactory(new PropertyValueFactory<>("contractPercent"));
        productsTabTableView.getItems().addAll(Simulation.getInstance().getProducts());
        usersTabTableView.getItems().addAll(Simulation.getInstance().getUsers());
        distributorsTabTableView.getItems().addAll(Simulation.getInstance().getDistributors());
        distributorsLabel.setText(Integer.toString(Simulation.getInstance().getDistributors().size()));
        usersLabel.setText(Integer.toString(Simulation.getInstance().getUsers().size()));
        productsLabel.setText(Integer.toString(Simulation.getInstance().getProducts().size()));
        Simulation.getInstance().getStage().setResizable(false);
        Simulation.getInstance().getStage().show();
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), mainAnchorPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(Simulation.getInstance().isRunning()) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("nowy wątek");
                        daysCounterLabel.setText(Integer.toString(Integer.parseInt(daysCounterLabel.getText())+1));
                    }
                }
            }
        });
        thread.start();
    }
}
