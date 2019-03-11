package sample;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class User implements Runnable{
    private String userId;
    private int[] dateOfBirth;
    private String email;
    private int cardNumber;
    private Subscription subscription;
    private SubscriptionType subscriptionType;
    private ArrayList<MovieishEntity> bought;
    private boolean running;
    public static ArrayList<String> emailAdresses = new ArrayList<>();
    public static ArrayList<String> emailDomains = new ArrayList<>();

    public User() {
        userId = "Domyślny użytkownik " + (Simulation.getInstance().getUsers().size()+1);
        dateOfBirth = new int[3];
        Random rand = new Random();
        dateOfBirth[0] = rand.nextInt(50)+1958;
        dateOfBirth[1] = rand.nextInt(12)+1;
        dateOfBirth[2] = rand.nextInt(28)+1;
        email = emailAdresses.get(rand.nextInt(emailAdresses.size()))+rand.nextInt(100)+"@"+emailDomains.get(rand.nextInt(emailDomains.size()));
        cardNumber = rand.nextInt(900000000)+100000000;
        subscription = new Subscription();
        subscriptionType = subscription.getType();
        bought = new ArrayList<>();
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(userId);
            try {
                sleep((new Random().nextInt(10)+5)*1000);
            } catch (InterruptedException e) {
                System.out.println("Stopping " + userId);
                break;
            }
            if(new Random().nextInt(2) == 1) {
                buy();
            }
        }
    }

    public synchronized void buy() {
        MovieishEntity tmp = Simulation.getInstance().getProducts().get(new Random().nextInt(Simulation.getInstance().getProducts().size()));
        Simulation.getInstance().setAccountState(Simulation.getInstance().getAccountState()+tmp.getPrice());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int[] getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int[] dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public ArrayList<MovieishEntity> getBought() {
        return bought;
    }

    public void setBought(ArrayList<MovieishEntity> bought) {
        this.bought = bought;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

