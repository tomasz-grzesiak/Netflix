package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Movie extends MovieishEntity {

    private MovieType type;
    private ArrayList<String> actors;
    private String link;
    private float loweredPrice;
    private int period;

    public Movie() {
        setEntityType("Film");                                                             //entityType
        Random rand = new Random();
        int tmp = rand.nextInt(Simulation.getInstance().getMovieTitles().size());
        setName(Simulation.getInstance().getMovieTitles().get(tmp));                       //name
        setDate(rand.nextInt(40)+1978);                                             //date
        setLength(rand.nextInt(70)+90);                                             //length
        setPrice(Math.round((rand.nextFloat()*8+10.0)*100.0)/100.0f);                       //price
        tmp = rand.nextInt(3)+1;
        HashSet<Integer> numbers = new HashSet<>();
        while(numbers.size() <= tmp) {
            numbers.add(rand.nextInt(Simulation.getInstance().getCountries().size()));
        }
        setCountries(new ArrayList<>());                                                  //countries, countriesString
        for (int i : numbers) {
            getCountries().add(Simulation.getInstance().getCountries().get(i));
            if(getCountriesString() == null) {
                setCountriesString(Simulation.getInstance().getCountries().get(i)+'\n');
            }
            else {
                setCountriesString(getCountriesString()+Simulation.getInstance().getCountries().get(i)+'\n');
            }
        }
        setNote(Math.round(rand.nextFloat()*1000)/100.0f);                                  //note
        type = MovieType.values()[rand.nextInt(6)];                                 //type
        tmp = rand.nextInt(5)+2;
        numbers = new HashSet<>();
        while(numbers.size() < tmp) {
            numbers.add(rand.nextInt(Simulation.getInstance().getActors().size()));
        }
        actors = new ArrayList<>();                                                         //actors
        for (Integer i : numbers) {
            actors.add(Simulation.getInstance().getActors().get(i));
        }
        link = "https://youtube.com/"+getName();                                            //link
        loweredPrice = ((float)(rand.nextInt(4)+5))/10*getPrice();                  //loweredPrice
        period = rand.nextInt(7)+8;                                                 //period
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public float getLoweredPrice() {
        return loweredPrice;
    }

    public void setLoweredPrice(float loweredPrice) {
        this.loweredPrice = loweredPrice;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
