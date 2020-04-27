import java.util.*;
public class Person {
    private String name;
    private int age;
    private Boolean isFemale;
    private Person father;
    private Person mother;
    private Set<Person> children;

    public Person(String name){
        this.name = name;
        this.age = 0;
    }

    public static String getName(Person dude){
        return dude.name;
    }

    public static int getAge(Person dude){
        return dude.age;
    }

    public static int happyBirthday(Person dude){
        dude.age++;
        System.out.println("Happy Birthday, " + dude.name + ".");
    }

    public Boolean isParent(Person compareto){
        if ((this.father == compareto)||(this.mother == compareto){
            return true
        } else{
            return false
        }
    }

    public Boolean isSibling(Person compareto){
        if ((this.father.children.contains(compareto))||(this.mother.children.contains(compareto))){
            return true;
        }
    }
}
