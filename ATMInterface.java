import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
      }
      
      public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit successful. Your balance: " + balance);
        } 
    }

public class ATMInterface {
    private Account account;

    public ATMInterface(Account account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Account account = new Account("123456789", "1234", 1000.0);
        ATMInterface atm = new ATMInterface(account);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (account.validatePin(enteredPin)) {
            System.out.println("Login successful.");
            atm.displayMenu();

            int choice;
            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance: " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wamount = scanner.nextDouble();
                        account.withdraw(wamount);
                        break;
                    case 3:
                        System.out.print("Enter Deposit amount: ");
                        double damount = scanner.nextDouble();
                        account.deposit(damount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 4);
        }
        else {
            System.out.println("Invalid PIN. Please try again.");
        }
    }
}




