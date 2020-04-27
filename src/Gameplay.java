import java.util.ArrayList;

public class Gameplay {

  private static int totalPeople;
  private static ArrayList<Person> population;
  private String townName;

  //constructors
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

  //create new person to add to population
  public static void born(Person parent1, Person parent2, String name){
    parent1.reproduce(parent2,name);
      Person baby = new Person(name, parent1, parent2);
      population.add(baby);
      totalPeople++;

  }

  public static void born(){
    born(null, null, null);
  }

  //remove person from population
  public static void die(Person person){
    population.remove(person);
    person.death();
    totalPeople--;
  }

  //return population size
  public static int getTotalPeople(){
    return totalPeople;
  }

  //return person at index
  public Person get(int i){
    return population.get(i);
  }



}

