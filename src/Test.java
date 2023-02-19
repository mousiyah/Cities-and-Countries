/*
CS-110 Autotest for Level 3 - at this level you need to be able to
1. do everything in Autotest for Level 2
2. delete cities by name - making sure that the population outside cities data is correctly updated
3. deal with incorrect data
*/
public class Test {
    public static void main(String[] args) {
        
        //LEVEL 1 TESTS
        Country argentina = new Country("Argentina", 45605800);
        argentina.addCity("Buenos Aires",13588200, -3);
        argentina.addCity("Cordoba", 1454650, -3);
        argentina.addCity("Rosario", 1236000, -3);
        argentina.addCity("Mendoza", 937200,-3);
        argentina.addCity("La Plata", 794300, -3);
        
        System.out.println(argentina);
        
        Country usa = new Country("USA", 331449300);
        usa.addCity("New York", 20140470, -5);
        usa.addCity("Dallas", 7637390, -6);
        usa.addCity("Phoenix", 4845800, -7);
        usa.addCity("Los Angeles", 13201000, -8);
        
        System.out.println(usa);
        
        Country russia = new Country("Russia", 146171000);
        russia.addCity("Moscow", 12506500, 3);
        russia.addCity("Vladivostok", 60500, 10);
        russia.addCity("Yekaterinburg", 1350000, 5);
        russia.addCity("Novosibirsk", 143750, 7);
        
        System.out.println(russia);
        
        //LEVEL 2 Tests
        System.out.printf("Time difference between %s and %s is %d hours%n",
            argentina.getCityByName("Cordoba").getName(),
            russia.getCityByName("Novosibirsk").getName(),
            argentina.getCityByName("Cordoba").timeDifference(russia.getCityByName("Novosibirsk")));
        System.out.printf("Time difference between %s and %s is %d hours%n",
            usa.getCityByName("Phoenix").getName(),
            argentina.getCityByName("Buenos Aires").getName(),
            usa.getCityByName("Phoenix").timeDifference(argentina.getCityByName("Buenos Aires")));
        
        //LEVEL 3 Tests
        System.out.println();//Blank line to make it easier to read the output
        //Delete some cities
        System.out.println("Deleting New York - worked? " + usa.deleteCity("New York"));
        System.out.println("Deleting Rosario - worked? " + argentina.deleteCity("Rosario"));
        System.out.println("Deleting Vladivostok - worked? " + russia.deleteCity("Vladivostok"));
        
        //Check they've been deleted
        System.out.println();//Blank line for readability again
        System.out.println(usa);
        System.out.println(argentina);
        System.out.println(russia);
        
        //Delete some places that don't exist
        System.out.println();//Blank line for readability again
        System.out.println("Deleting Boston - worked? " +usa.deleteCity("Boston"));
        System.out.println("Deleting St Petersburg - worked? " +russia.deleteCity("St Petersburg"));
        
        //Add some nonsense data
        Country gulliver = new Country("Gulliver's World", -1);
        gulliver.addCity("Lilliput", 0, 99);
        gulliver.addCity("Brobdingnag", -10, -13);
        System.out.println(gulliver);
        
        //Check that data is legal
        System.out.println();//Blank line for readability again
        System.out.println("Gulliver's World legal data ?" + gulliver.isLegalData());
        System.out.println("Lilliput legal data? " + gulliver.getCityByName("Lilliput").isLegalData());
        System.out.println("Los Angeles legal data? " + usa.getCityByName("Los Angeles").isLegalData());
    }
}
