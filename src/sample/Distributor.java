package sample;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Distributor implements Runnable{

    private String distributorId;
    private float contractValue;
    private float contractPercent;
    private boolean running;

    public Distributor() {
        Random rand = new Random();
        distributorId = "Domyślny dystrybutor "+(Simulation.getInstance().getDistributors().size()+1);
        contractValue = Math.round((rand.nextFloat()*70+150)*100)/100.0f;
        contractPercent = Math.round(rand.nextFloat()*20+50)/100.0f;
        running = false;
    }

    @Override
    public void run() {
        System.out.println(distributorId);
        while (running) {
            try {
                sleep((new Random().nextInt(10)+5)*1000);
            } catch (InterruptedException e) {
                break;
            }
            if(new Random().nextInt(2) == 1) {
                createProduct();
            }
            if(new Random().nextInt(2) == 1) {
                renegotiate();
            }
        }
    }

    public void createProduct() {
        int a = (new Random()).nextInt(3);
        if (a == 0) {
            MovieishEntity tmp = new Movie();
            tmp.setDistributor(this);
            Simulation.getInstance().getProducts().add(tmp);
        }
        else if (a == 1) {
            MovieishEntity tmp = new Series();
            tmp.setDistributor(this);
            Simulation.getInstance().getProducts().add(tmp);
        }
        else {
            MovieishEntity tmp = new LiveStreaming();
            tmp.setDistributor(this);
            Simulation.getInstance().getProducts().add(tmp);
        }
    }

    public synchronized void renegotiate() {
        float tmp = Math.round((new Random().nextFloat()*70+150)*100)/100.0f;
        Simulation.getInstance().setAccountState(Simulation.getInstance().getAccountState()+contractValue-tmp);
        contractValue = tmp;
    }


    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String id) {
        this.distributorId = id;
    }

    public float getContractValue() {
        return contractValue;
    }

    public void setContractValue(float contractValue) {
        this.contractValue = contractValue;
    }

    public float getContractPercent() {
        return contractPercent;
    }

    public void setContractPercent(float contractPercent) {
        this.contractPercent = contractPercent;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
