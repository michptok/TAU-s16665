import java.util.Scanner;

public class Dog {

    private String breed;
    private String id;
    private String gender;
    private String name = " ";
    private int age;
    private boolean isDogHere = false;
    Scanner scan = new Scanner(System.in);


    public Dog() {
    }

    public void meetSheriff() {
        System.out.println("Beware the Sheriff of the shelter!");
        System.out.println("https://pl.pinterest.com/pin/369435975664922613/");
    }

    public void add() {
        if (isDogHere) {
            System.out.println("The shelter can take care of only one dog at the time!");
            System.out.println("First remove the dog, then add new one!");
        } else {
            System.out.println("Please provide the name for the good boi: ");
            String enteredName = scan.nextLine();
            if (enteredName.equals("Bad Boi") || enteredName.isEmpty()) {
                System.out.println("You are Bad Boi. Next time please enter a correct name!");
            } else {
                isDogHere = true;
                setName(enteredName);
            }
        }
    }
    public void provideAge() {
        if (!isDogHere) {
            System.out.println("The dog hasn't been added yet!");
            System.out.println("First add the dog, then add age!");
        } else {
            System.out.println("Please provide the age for the good boi: ");
            int enteredAge = scan.nextInt();
            if (enteredAge < 1 ) {
                System.out.println("You are Bad Boi. Next time please enter a correct number!");
            } else {
                setAge(enteredAge);
            }
        }
    }

    public void remove() {
        if (!isDogHere) {
            System.out.println("The shelter is already empty!\n");
        } else {
            clearShelter();
            System.out.println("The dog was removed from the shelter");
            System.out.println("The shelter is now empty");
        }
    }

    public void getName() {
        if (!isDogHere || name.isEmpty()) {
            System.out.println("The dog hasn't been added yet!");
        } else {
            System.out.println("The name is: " + name);
        }
    }

    public void getAge() {
        if (age < 1 || !isDogHere) {
            System.out.println("Age was not set or the dog hasn't been added yet!");
            System.out.println("First add the dog, then add age!");
        } else {
            System.out.println("The age of the dog is: " + age);
        }
    }

    void clearShelter(){
        name = "";
        age = 0;
        isDogHere = false;
    }

    void setName(String enteredName) {
        name = enteredName;
    }

    void setAge(int enteredAge) {
        if (enteredAge < 0) {
            throw new IllegalArgumentException();
        } else {
            age = enteredAge;
        }
    }
}
