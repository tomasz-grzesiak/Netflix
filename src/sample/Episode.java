package sample;

import java.time.LocalDate;
import java.util.Random;

public class Episode {
    private String title;
    private int year;
    private int month;
    private int day;
    private LocalDate date;
    private int duration;

    public Episode(String str, int year) {
        title = new String(str);
        this.year = year;
        Random rand = new Random();
        month = rand.nextInt(12)+1;
        day = rand.nextInt(28)+1;
        duration = rand.nextInt(20)+35;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
