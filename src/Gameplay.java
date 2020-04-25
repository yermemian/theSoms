import java.util.ArrayList;

public class Gameplay {

  public static int totalPeople;
 // private int totalPeople;
  private static ArrayList<Person> population;
  private String townName;

  public Gameplay(){
    totalPeople = 0;
    population = new ArrayList<Person>();
    townName = null;
  }

  public Gameplay(int size, String name){
    totalPeople = size;
    population = new ArrayList<Person>(100);
    townName = name;
  }

  public static void born(Person parent1, Person parent2, String name){
    Person baby = new Person(name);
    population.add(baby);
    totalPeople++;
  }

  public static void die(Person person){
    population.remove(person);
    totalPeople--;
  }

  public int populationSize(){
    return totalPeople;
  }



}

