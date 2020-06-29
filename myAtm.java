import java.util.Scanner;

public class myAtm {

    private static Scanner in;
    private static float balance = 0; // initial balance for customers usually starts from 0
    private static int newTransaction;

    public static void main(String args[]) {
        in = new Scanner(System.in);

        // calling our transaction method
        transaction();
    }

    private static void transaction() {
        int choice;

        System.out.println("Please choose your transaction:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");

        choice = in.nextInt();

        switch (choice) {
            case 1:
                float amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = in.nextFloat();
                if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    newTransaction(); // ask if customer wants new transaction
                } else {
                    // customer has funds and now, update balance
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    newTransaction();
                }
                break;

            case 2:
                // depositing funds
                float deposit;
                System.out.println("Please enter the amount you wish to deposit: ");
                deposit = in.nextFloat();
                // updating the balance
                balance = deposit + balance;
                System.out.println("You have deposited " + deposit + " new balance is " + balance + " \n");
                newTransaction();
                break;

            case 3:
                // Checking balance
                System.out.println("Your balance is " + balance + "\n");
                newTransaction();
                break;

            default:
                System.out.println("Invalid Choice... Option not recognized\n\n");
                newTransaction();
                break;
        }
    }

    private static void newTransaction() {
        System.out.println("Do you want another transaction?\n\n");
        System.out.println("Press 1 for another transaction\n\n");
        System.out.println("Press 2 to exit\n");

        newTransaction = in.nextInt();
        if (newTransaction == 1) {
            transaction(); // calling transaction method here
        } else if (newTransaction == 2) {
            System.out.println("Thanks for banking with us. Bye!");
        } else {
            System.out.println("Invalid choice.... Option not recognized\n\n");
            newTransaction();
        }
    }
}