import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestGameplay {

    ArrayList<Person> pop = new ArrayList<>(100);

    @Test // should test if baby is added to pop and if population size increases
    public void born() {
        Person Jane = new Person("Jane");
        Person John = new Person("John");
        pop.add(Jane);
        pop.add(John);
        Gameplay.born(Jane, John, "Billy");
        assertEquals(3, pop.size());
    }

    @Test // should test if person is removed from pop/population size decreases
    public void die() {
        Person Dave = new Person("Dave");
        Person Jessica = new Person("Jessica");
        pop.add(Dave);
        pop.add(Jessica);
        assertEquals(2, pop.size());
        Gameplay.die(Dave);
        assertEquals(1, pop.size());
    }

    @Test
    public void getTotalPeople() {
        Person Steven = new Person("Steven");
        Person Jamie = new Person("Jamie");
        Person Jessica = new Person ("Jessica");
        pop.add(Steven);
        pop.add(Jamie);
        pop.add(Jessica);
        System.out.println(pop.toString());
        System.out.println(pop.size());
        assertEquals(3, Gameplay.getTotalPeople());
    }
}