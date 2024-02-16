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

          // Adjust choice to match array indexing
          Snack selectedSnack = snacks[choice - 1];
          System.out.printf("You have selected %s. Please insert $%.2f, accepting only $1 bills.\n", selectedSnack.getName(), selectedSnack.getPrice());
  
          double totalInserted = 0;
          while (totalInserted < selectedSnack.getPrice()) {
              System.out.println("Insert $1 bill (Press any key and enter to insert $1 bill):");
              scanner.next(); // Simulate inserting money
              totalInserted += 1; // Assume each insertion is a $1 bill
              System.out.printf("Total inserted: $%.2f\n", totalInserted);
          }
          
          double change = totalInserted - selectedSnack.getPrice();
          System.out.printf("Your change is $%.2f. Confirm transaction? (yes/no)\n", change);
          String confirmation = scanner.next();
  
          if ("yes".equalsIgnoreCase(confirmation)) {
              System.out.printf("Transaction successful. Enjoy your %s!\n", selectedSnack.getName());
              if (change > 0) {
                  System.out.printf("Don't forget your change: $%.2f\n", change);
              }
          } else {
              System.out.println("Transaction cancelled. Please take your refund.");
          }
  
          System.out.println("Thank you for using the Vending Machine. Have a great day!");
      }
  
    }
