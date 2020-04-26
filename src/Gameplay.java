import java.util.ArrayList;

public class Gameplay {

  private static int totalPeople;
  private static ArrayList<Person> population;
  private String townName;

  public Gameplay(){
    totalPeople = 0;
    population = new ArrayList<Person>();
    townName = null;
  }

  public Gameplay(ArrayList<Person> pop, String name){
    totalPeople = pop.size();
    population = pop;
    townName = name;
  }

  public static void born(String name){
    Person baby = new Person(name);
    population.add(baby);
    totalPeople++;
  }

  public static void born(){
    born(null);
  }

  public static void die(Person person){
    population.remove(person);
    totalPeople--;
  }

  public int getTotalPeople(){
    return totalPeople;
  }

  public Person get(int i){
    return population.get(i);
  }



}

