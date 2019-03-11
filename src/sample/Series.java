package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Series extends MovieishEntity {
    private MovieType type;
    private ArrayList<String> actors;
    private int seasonsCounter;
    private ArrayList<Episode> episodes;

    public Series() {
        setEntityType("Serial");                                                        //entityType
        Random rand = new Random();
        int tmp = rand.nextInt(Simulation.getInstance().getSeriesTitles().size());
        setName(Simulation.getInstance().getSeriesTitles().get(tmp));                    //name
        setDate(rand.nextInt(40)+1978);                                         //date
        setLength(rand.nextInt(70)+90);                                         //length
        setPrice(Math.round((rand.nextFloat()*8+10.0)*100.0)/100.0f);                   //price
        tmp = rand.nextInt(3)+1;
        HashSet<Integer> numbers = new HashSet<Integer>();
        while(numbers.size() <= tmp) {
            numbers.add(rand.nextInt(Simulation.getInstance().getCountries().size()));
        }
        setCountries(new ArrayList<>());                                                //countries, countriesString
        for (int i : numbers) {
            getCountries().add(Simulation.getInstance().getCountries().get(i));
            if(getCountriesString() == null) {
                setCountriesString(Simulation.getInstance().getCountries().get(i)+'\n');
            }
            else {
                setCountriesString(getCountriesString()+Simulation.getInstance().getCountries().get(i)+'\n');
            }
        }
        setNote(Math.round(rand.nextFloat()*1000)/100.0f);                              //note
        type = MovieType.values()[rand.nextInt(6)];                             //type
        tmp = rand.nextInt(5)+2;
        numbers = new HashSet<>();
        while(numbers.size() < tmp) {
            numbers.add(rand.nextInt(Simulation.getInstance().getActors().size()));
        }
        actors = new ArrayList<>();                                                     //actors
        for (Integer i : numbers) {
            actors.add(Simulation.getInstance().getActors().get(i));
        }
        seasonsCounter = rand.nextInt(4)+5;                                     //seasonsCounter
        episodes = new ArrayList<>();                                                   //episodes
        for (int i = 0; i < (rand.nextInt(5)+7)*seasonsCounter; i++) {
            episodes.add(new Episode("S"+(i/seasonsCounter+1)+"E"+(i%seasonsCounter+1), getDate()));
        }
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

    public int getSeasonsCounter() {
        return seasonsCounter;
    }

    public void setSeasonsCounter(int seasonsCounter) {
        this.seasonsCounter = seasonsCounter;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }
}
