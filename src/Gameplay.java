import java.util.ArrayList;

public class Gameplay {

  private int totalPeople;
  private ArrayList<Person> population;
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

  public void born(Person parent1, Person parent2, String name){
    Person baby = new Person();
    population.add(baby);
    totalPeople++;
  }

  public void die(Person person){
    population.remove(person);
    totalPeople--;
  }
  


}

