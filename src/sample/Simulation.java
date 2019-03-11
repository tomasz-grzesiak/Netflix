package sample;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

public class Simulation {

    private static Simulation ourInstance = new Simulation();

    public static Simulation getInstance() {
        return ourInstance;
    }

    private ArrayList<String> actors;
    private ArrayList<String> countries;
    private ArrayList<String> movieTitles;
    private ArrayList<String> liveStreamingTitles;
    private ArrayList<String> seriesTitles;

    private Stage stage;
    public AnchorPane anchorPane;

    volatile private float accountState;
    private float balance;
    volatile private boolean running;
    private int daysCounter;
    volatile private ArrayList<MovieishEntity> products;
    private ArrayList<User> users;
    private ArrayList<Distributor> distributors;
    private ThreadPoolExecutor executor;

    private Simulation() {
        running = false;
        daysCounter = 0;
        stage = new Stage();
        actors = new ArrayList<>();
        countries = new ArrayList<>();
        movieTitles = new ArrayList<>();
        seriesTitles = new ArrayList<>();
        liveStreamingTitles = new ArrayList<>();
        try {
            Scanner actorsScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\actors.txt"));
            while(actorsScanner.hasNextLine()) {
                actors.add(actorsScanner.nextLine());
            }
            actorsScanner.close();
            Scanner countriesScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\countries.txt"));
            while(countriesScanner.hasNextLine()) {
                countries.add(countriesScanner.nextLine());
            }
            countriesScanner.close();
            Scanner movieTitlesScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\movies.txt"));
            while(movieTitlesScanner.hasNextLine()) {
                movieTitles.add(movieTitlesScanner.nextLine());
            }
            movieTitlesScanner.close();
            Scanner seriesTitlesScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\series.txt"));
            while(seriesTitlesScanner.hasNextLine()) {
                seriesTitles.add(seriesTitlesScanner.nextLine());
            }
            seriesTitlesScanner.close();
            Scanner liveStreamingTitlesScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\liveStreaming.txt"));
            while(liveStreamingTitlesScanner.hasNextLine()) {
                liveStreamingTitles.add(liveStreamingTitlesScanner.nextLine());
            }
            liveStreamingTitlesScanner.close();
            Scanner emailAdressesScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\emailAdresses.txt"));
            while(emailAdressesScanner.hasNextLine()) {
                User.emailAdresses.add(emailAdressesScanner.nextLine());
            }
            emailAdressesScanner.close();
            Scanner emailDomainsScanner = new Scanner(new FileInputStream("C:\\Users\\oem\\Desktop\\Studia\\III\\Programowanie obiektowe\\Netflix\\src\\data\\emailDomains.txt"));
            while(emailDomainsScanner.hasNextLine()) {
                User.emailDomains.add(emailDomainsScanner.nextLine());
            }
            emailDomainsScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        products = new ArrayList<>();
        users = new ArrayList<>();
        distributors = new ArrayList<>();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(500);
        accountState = 0.0f;
    }

    public void createProduct() {
        distributors.get(new Random().nextInt(distributors.size())).createProduct();
    }

    public void createDistributor() {
        distributors.add(new Distributor());
     }

    public void createUser() {
        users.add(new User());
    }

      public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public float getAccountState() {
        return accountState;
    }

    public void setAccountState(float accountState) {
        this.accountState = accountState;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public ArrayList<MovieishEntity> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<MovieishEntity> products) {
        this.products = products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(ArrayList<Distributor> distributors) {
        this.distributors = distributors;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getMovieTitles() {
        return movieTitles;
    }

    public void setMovieTitles(ArrayList<String> movieTitles) {
        this.movieTitles = movieTitles;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public ArrayList<String> getSeriesTitles() {
        return seriesTitles;
    }

    public void setSeriesTitles(ArrayList<String> seriesTitles) {
        this.seriesTitles = seriesTitles;
    }

    public ArrayList<String> getLiveStreamingTitles() {
        return liveStreamingTitles;
    }

    public void setLiveStreamingTitles(ArrayList<String> liveStreamingTitles) {
        this.liveStreamingTitles = liveStreamingTitles;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getDaysCounter() {
        return daysCounter;
    }

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }
}
