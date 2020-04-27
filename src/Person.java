import java.util.*;
public class Person {
    private String name;
    public int age;
    private Boolean isFemale;
    private Person father;
    private Person mother;
    private Set<Person> children;
    private Boolean isAlive;

    public Person(String name){
        this.name = name;
        this.age = 0;
        this.isFemale = null;
        this.father = null;
        this.mother = null;
        this.children = null;
        this.isAlive = true;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.isFemale = null;
        this.father = null;
        this.mother = null;
        this.children = null;
        this.isAlive = true;
    }

    public Person(String name, Person mother, Person father){
        this.name = name;
        this.age = 0;
        this.isFemale = null;
        this.father = father;
        this.mother = mother;
        this.children = null;
        this.isAlive = true;
    }

    public static String getName(Person dude){
        return dude.name;
    }

    public static int getAge(Person dude){
        return dude.age;
    }

    public static void happyBirthday(Person dude){
        dude.age++;
        System.out.println("Happy Birthday, " + dude.name + ".");
    }

    public Boolean isParent(Person compareto){
        if ((this.father == compareto)||(this.mother == compareto)){
            return true;
        } else {
            return false;
        }
    }

    public Boolean isSibling(Person compareto){
        if ((this.father.children.contains(compareto))||(this.mother.children.contains(compareto))){
            return true;
        } else{
            return false;
        }
    }

    public Person reproduce(Person partner){
        Scanner keyboard = new Scanner(System.in);
        Boolean areDifferentSexes = (((this.isFemale)||(partner.isFemale))&& (!((this.isFemale)&&(partner.isFemale))));
        Boolean areOfAge = ((this.age > 16) && (partner.age > 16));
        Boolean areAlive = (this.isAlive && partner.isAlive);
        if (areDifferentSexes && areOfAge && areAlive){
            System.out.println("Congratulations! Enter a name for your new child!");
            String name = keyboard.nextLine();
            if (this.isFemale){
                Person mother = this;
                Person father = partner;
            } else {
                Person father = this;
                Person mother = partner;
            }
            Person child = new Person(name, father, mother);
            this.children.add(child);
            partner.children.add(child);
        } else if(!areDifferentSexes){
            System.out.println("These people are biological incapable of mating!");
            return null;
        } else if(!areOfAge){
            System.out.println("Knock it out, youngsters!");
            return null;
        } else if(!areAlive){
            System.out.println("Dead people can't reproduce!");
            return null;
        }
    }

    public void death(){
        this.isAlive = false;
    }
}
