import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestGameplay {

    ArrayList<Person> pop = new ArrayList<>(100);

    @Test
    public void getTotalPeopleInitial() {
        Gameplay game = new Gameplay(pop, "test");
        assertEquals(0, game.getTotalPeople());
    }

    @Test
    public void getTotalPeople() {
        Person Steven = new Person("Steven");
        Person Jamie = new Person("Jamie");
        Person Jessica = new Person ("Jessica");
        pop.add(Steven);
        pop.add(Jamie);
        pop.add(Jessica);
        Gameplay game = new Gameplay(pop, "test");
        assertEquals(3, game.getTotalPeople());
    }

    @Test // should test if baby is added to pop and if population size increases
    public void born() {
        Person Jane = new Person("Jane", 20, true);
        Person John = new Person("John",20,false);
        pop.add(Jane);
        pop.add(John);
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        assertEquals(3, pop.size());
    }

    @Test // should test if person is removed from pop/population size decreases
    public void die() {
        Person Dave = new Person("Dave");
        Person Jessica = new Person("Jessica");
        pop.add(Dave);
        pop.add(Jessica);
        Gameplay game = new Gameplay(pop, "test");
        assertEquals(2, pop.size());
        game.die(Dave);
        assertEquals(1, pop.size());
    }

    @Test
    public void getName() {
        Person Bartholomew = new Person("Bartholomew");
        assertEquals("Bartholomew", Person.getName(Bartholomew));
    }

    @Test
    public void getAge() {
        Person Bartholomew = new Person("Bartholomew", 7);
        assertEquals(7, Person.getAge(Bartholomew));
    }

    @Test
    public void getAgeInitial() {
        Person Jane = new Person("Jane",20,true);
        Person John = new Person("John",20,false);
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        assertEquals(0, Person.getAge(pop.get(0)));
    }

    @Test
    public void happyBirthday() {
        Person Dave = new Person("Dave", 49);
        Person.happyBirthday(Dave);
        assertEquals(50, Person.getAge(Dave));
    }

    @Test
    public void isParentTrue() {
        Person Jane = new Person("Jane");
        Person John = new Person("John");
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        assertTrue(John.isParent(pop.get(0)));
        assertTrue(Jane.isParent(pop.get(0)));
    }

    @Test
    public void isParentFalse() {
        Person Jane = new Person("Jane");
        Person John = new Person("John");
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        Person Jimmy = new Person("Jimmy");
        assertFalse(Jimmy.isParent(pop.get(0)));
    }

    @Test
    public void isSiblingTrue() {
        Person Jane = new Person("Jane");
        Person John = new Person("John");
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        game.born(Jane, John, "Queen Elizabeth");
        assertTrue(pop.get(0).isSibling(pop.get(1)));
    }

    @Test
    public void isSiblingFalse() {
        Person Jane = new Person("Jane");
        Person John = new Person("John");
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        Person Jimmy = new Person("Jimmy");
        Person Ellie = new Person("Ellie");
        game.born(Jimmy, Ellie, "Bobby");
        assertFalse(pop.get(0).isSibling(pop.get(1)));
    }

    @Test
    public void isHalfSibling() {
        Person Jane = new Person("Jane",20,true);
        Person John = new Person("John",20,false);
        Gameplay game = new Gameplay(pop, "test");
        game.born(Jane, John, "Billy");
        Person Jimmy = new Person("Jimmy");
        game.born(Jimmy, Jane, "Bobby");
        assertTrue(pop.get(0).isSibling(pop.get(1)));
    }

    @Test
    public void reproduceDead() {
        Person June = new Person("June",20,true);
        Person Jeff = new Person("Jeff",20,false);
        Gameplay game = new Gameplay(pop, "test");
        game.die(Jeff);
        assertFalse(Jeff.reproduce(June,"baby"));
    }

    @Test
    public void reproduceYoung() {
        Person June = new Person("June", 15, true);
        Person Jeff = new Person("Jeff", 16, false);
        assertFalse(June.reproduce(Jeff,"baby"));
    }

    @Test
    public void reproduceSameSex() {
        Person June = new Person("June", 30, true);
        Person Danielle = new Person("Danielle", 30, true);
        assertFalse(June.reproduce(Danielle,"baby"));
    }

    @Test
    public void reproduceSuccess() {
        Person June = new Person("June", 30);
        Person Jeff = new Person("Jeff", 35);
        June.isFemale = true;
        Jeff.isFemale = false;
        assertTrue(June.reproduce(Jeff,"baby"));
    }
}