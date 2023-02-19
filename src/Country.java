/*

In the coursework 1 following improvements were suggested:
    - make final variable names more clear
    (instead of "BARREL_1" use "BARREL_ONE_STARTING_VALUE")
    - commenting was like a storytelling
    (described how code works instead of telling what it achieves)
    - have used "continue" statements inside loops which was strongly discouraged

In the coursework 2 I made following changes to respond to the feedback:
    - used appropriate names for final variables
    ("TIME_ZONE_MIN", "TIME_ZONE_MAX", "MEGACITY_MIN_POPULATION")
    - improved commenting by stating what the specific lines of code achieve
    - did not use any "continue" statements inside loops

 */

import java.util.ArrayList;

public class Country {

    private String name;
    private int population;
    private int populationOfListedCities = 0;
    private int populationOutsideListedCities;
    private ArrayList<City> cities = new ArrayList<>();

    public Country(String countryName, int countryPopulation) {
        setName(countryName);
        setPopulation(countryPopulation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    // sets this.population to zero if population is less than zero
    public void setPopulation(int population) {
        this.population = Math.max(population, 0);
    }

    // updates population of outside listed cities
    public void setPopulationOutsideListedCities() {
        populationOutsideListedCities = population - populationOfListedCities;
    }

    // adds a new city to arraylist
    public void addCity(String cityName, int cityPopulation, int cityTimeZone) {
        if (cityPopulation > 0) {
            populationOfListedCities += cityPopulation;
            setPopulationOutsideListedCities();
        }
        cities.add(new City(cityName, cityPopulation, cityTimeZone));
    }

    // gets a city object by its name
    public City getCityByName(String cityName) {
        // loop for searching for the right city
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        
        return null;
    }

    // removes the city from the arraylist
    public boolean deleteCity(String cityName) {
        if (cities.contains(getCityByName(cityName))) {
            populationOfListedCities -= getCityByName(cityName).getPopulation();
            setPopulationOutsideListedCities();
            cities.remove(getCityByName(cityName));
            return true;
        }else {
            return false;
        }
    }

    // true if population more than zero
    public boolean isLegalData() {
        return population > 0;
    }

    @Override
    public String toString() {
        StringBuilder countryToString = new StringBuilder(name
                + ": total population: " + population
                + ", population outside listed cities: " + populationOutsideListedCities
                + ", with cities" + "\n");

        for (City city : cities) {
            countryToString.append(city.toString());
            countryToString.append("\n");
        }

        return countryToString.toString();
    }

}
