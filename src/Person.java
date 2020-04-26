public class Person {
    private String name;
    private int age;

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
}
