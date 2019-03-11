package sample;

import java.util.ArrayList;
import java.util.Random;


public class LiveStreaming extends MovieishEntity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public LiveStreaming() {
        setEntityType("Live streaming");                                                        //entityType
        Random rand = new Random();
        int tmp = rand.nextInt(Simulation.getInstance().getLiveStreamingTitles().size());
        setName(Simulation.getInstance().getLiveStreamingTitles().get(tmp));                    //name
        setDate(2019);                                                                          //date
        setLength(rand.nextInt(100)+70);                                                //length
        setPrice(Math.round((rand.nextFloat()*12+12.0)*100.0)/100.0f);                          //price
        setCountries(new ArrayList<>());                                                        //countries(1)
        tmp = rand.nextInt(Simulation.getInstance().getCountries().size());
        getCountries().add(Simulation.getInstance().getCountries().get(tmp));
        setCountriesString(getCountries().get(0));                                             //countriesString
        setNote(Math.round(rand.nextFloat()*1000)/100.0f);                                      //note
        year = 2019;                                                                            //year
        month = rand.nextInt(12)+1;                                                     //month
        day = rand.nextInt(28)+1;                                                       //day
        hour = rand.nextInt(24);                                                        //hour
        minute = rand.nextInt(60);                                                      //minute
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
