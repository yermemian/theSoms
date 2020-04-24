public class main{
    public static void main {

        //enter name of town
        Scanner input = new Scanner (System.in);
        System.out.print("Input what you would like to name your town: ")
    String townName = input.next();
    System.out.println("The name of your town is" + townName);

    //starting population
    int totalPeople = 100;

    while (born > die) {
        totalPeople = totalPeople + 1;
        return totalPeople;
    }
    //add new kids to the population  = born
    //take away numbers if people die = die

    while (populationSize > 0){
    //keep the game running
    processInput();
    update();
    render();
    }
    // not really sure about this part... I googled how to make a game loop...
    // so I think it might make our game run,
    // but im not sure how to test it without the other parts of the code
    // and it seems too simple to me but idk


    //print out info about family and individual people
    System.out.println("Family a has" + length(a) + " people in it");
    System.out.println("Yours towns population is: " + populationSize);

    }
}
