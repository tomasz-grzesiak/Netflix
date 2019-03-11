package sample;

import java.util.Random;

public class Subscription {
    private SubscriptionType type;
    private float price;
    private int devicesCounter;
    private ResolutionType resolution;

    public Subscription() {
        type = SubscriptionType.values()[new Random().nextInt(3)];
        if (type == SubscriptionType.Basic) {
            price = 43.99f;
            devicesCounter = 2;
            resolution = ResolutionType.Normal;
        }
        if (type == SubscriptionType.Family) {
            price = 54.49f;
            devicesCounter = 4;
            resolution = ResolutionType.HD;
        }
        if (type == SubscriptionType.Premium) {
            price = 62.99f;
            devicesCounter = 7;
            resolution = ResolutionType.HD4k;
        }
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDevicesCounter() {
        return devicesCounter;
    }

    public void setDevicesCounter(int devicesCounter) {
        this.devicesCounter = devicesCounter;
    }

    public ResolutionType getResolution() {
        return resolution;
    }

    public void setResolution(ResolutionType resolution) {
        this.resolution = resolution;
    }
}
