public class City {

    private static final int TIME_ZONE_MIN = -12;
    private static final int TIME_ZONE_MAX = 12;
    private static final int MEGACITY_MIN_POPULATION = 10000000;
    private boolean isLegalTimeZone = true;

    private String name;
    private int population;
    private int timeZone;

    public City(String name, int population, int timeZone) {
        setName(name);
        setPopulation(population);
        setTimeZone(timeZone);
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

    public int getTimeZone() {
        return timeZone;
    }

    // sets this.timeZone to 0 if timeZone is not legal
    public void setTimeZone(int timeZone) {
        if (timeZone < TIME_ZONE_MIN || timeZone > TIME_ZONE_MAX) {
            timeZone = 0;
            isLegalTimeZone = false;
        }
        this.timeZone = timeZone;
    }

    // the time difference between two cities
    public int timeDifference(City anotherCity) {
        return getTimeZone() - anotherCity.getTimeZone();
    }

    public String isMegacity() {
        if (population >=  MEGACITY_MIN_POPULATION) {
            return "It IS a megacity";
        }else {
            return "It IS NOT a megacity";
        }
    }

    // true if population is legal & timezone when the object have been created was legal
    public boolean isLegalData() {
        return population > 0 && isLegalTimeZone;
    }


    @Override
    public String toString() {
        String cityToString = name
                + ": has population " + population
                + " and is in time zone " + timeZone
                + ". " + isMegacity();

        return cityToString;
    }

}
