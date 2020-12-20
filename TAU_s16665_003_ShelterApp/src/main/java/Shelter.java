import java.util.InputMismatchException;
import java.util.Scanner;

public class Shelter {

    private static final String optionOneMessage = "1 - Add dog";
    private static final String optionTwoMessage = "2 - Display name of the dog";
    private static final String optionThreeMessage = "3 - Display the age of the dog";
    private static final String optionFourMessage = "4 - Meet Sheriff";
    private static final String optionFiveMessage = "5 - Remove the dog";
    private static final String optionSixMessage = "6 - Provide age of the dog";
    private static final String optionExitMessage = "7 - Exit";

    public static void main(String[] args) {
        Dog d = new Dog();
        Scanner scan = new Scanner(System.in);
        String enterNumberMessage = "\nPlease choose menu option by entering a number!";

        int choice;
        do {
            displayMenu();

            while (true) {
                try {
                    choice = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(enterNumberMessage);
                    scan.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Option " + optionOneMessage + "\n");
                    d.add();
                    break;
                case 2:
                    System.out.println("Option " + optionTwoMessage + "\n");
                    d.getName();
                    break;
                case 3:
                    System.out.println("Option " + optionThreeMessage + "\n");
                    d.getAge();
                    break;
                case 4:
                    System.out.println("Option " + optionFourMessage + "\n");
                    d.meetSheriff();
                    break;
                case 5:
                    System.out.println("Option " + optionFiveMessage + "\n");
                    d.remove();
                    break;
                case 6:
                    System.out.println("Option " + optionSixMessage + "\n");
                    d.provideAge();
                    break;
                case 7:
                    System.out.println("Option " + optionExitMessage + "\n");
                    System.out.println("App will close in 3s");
                    pause();
                    System.exit(0);
                default:
                    System.out.println(enterNumberMessage);
                    break;
            }
        } while (choice >= 0);
    }

    static void displayMenu() {
        System.out.println("\n--- ShelterApp ---");
        System.out.println("Welcome to the ShelterApp that should not be used by anyone! \nYou can only fit one dog here.");
        System.out.println(optionOneMessage);
        System.out.println(optionTwoMessage);
        System.out.println(optionThreeMessage);
        System.out.println(optionFourMessage);
        System.out.println(optionFiveMessage);
        System.out.println(optionSixMessage);
        System.out.println(optionExitMessage);
        System.out.println("--- ---------- ---");
    }

    static void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}