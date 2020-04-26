import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;




public class Driver {
  public static void main (String[] args){
    //enter name of town
    Scanner input = new Scanner (System.in);
    System.out.print("Input what you would like to name your town: ");
    String townName = input.next();
    System.out.println("The name of the town is" + townName);
    System.out.println("How many people do you want in your town? ");
    int popSize = input.nextInt();

    // initializing and adding to an array list denoting town population based on size
    ArrayList<Person> gamePopulation = new ArrayList<Person>(popSize + 10000);

    Person person;
    for (int i = 0; i < popSize; i++){
      //person contructor to get the person
      person = new Person();
      //add the person to the game
      gamePopulation.add(i, person);
    }
    //create a new instance of Gameplay passing in the array list of the town's population
    Gameplay game = new Gameplay(gamePopulation, townName);
    // main game loop, the game keeps going as long as there is at least one person alive

    while (game.getTotalPeople() > 0) {
      // pauses the loop for 10 seconds so it doesnt overwhelm the computer
      TimeUnit.SECONDS.sleep(10);
      System.out.println("How many people are born? ");
      int bornNumber = input.nextInt();
      for(int b = 0; b < bornNumber; b++){
        Gameplay.born();
      }
      System.out.println("How many people die?");
      int dieNumber = input.nextInt();
      for(int d = game.getTotalPeople()-1; d > (game.getTotalPeople() - dieNumber); d--){
        person = game.get(d);
        Gameplay.die(person);
      }
      System.out.println("Population: " + game.getTotalPeople());
    }
  }
}