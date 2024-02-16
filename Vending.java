package Assignment4;

import java.util.Scanner;

public class Vending {

    private static final Snack[] snacks = new Snack[5];
    private static final Scanner scanner = new Scanner(System.in);

    static {
        // Initialize the vending machine with some snacks and their prices
        snacks[0] = new Snack("Twix", 1.50);
        snacks[1] = new Snack("Bueno Bar", 2.00);
        snacks[2] = new Snack("Coke", 2.50);
        snacks[3] = new Snack("Cookies", 1.75);
        snacks[4] = new Snack("Trident Gum", 0.95);
    }



    public static void main(String[] args) {
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Here are the available snacks:");

        for (int i = 0; i < snacks.length; i++) {
            System.out.printf("%d. %s - $%.2f\n", i + 1, snacks[i].getName(), snacks[i].getPrice());
        }

        System.out.println("Please pick the snack you want to buy by entering the corresponding number:");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > snacks.length) {
            System.out.println("Invalid choice, please try again:");
            choice = scanner.nextInt();
        }
    }
}
