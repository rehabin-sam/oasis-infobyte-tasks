import java.util.*;

class BankAccount {
    static void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your full name :");
        ATM.userName = input.nextLine();
        System.out.println("Create a username :");
        String username = input.nextLine();
        System.out.println("Create a password :");
        String password = input.nextLine();
        System.out.println("Enter your Account Number :");
        ATM.accountNumber = input.nextLine();
        System.out.println("Account Created Successfully!");
        System.out.println("---------------------------");
        ATM.userMenu();
        while (true) {
            options(ATM.userName);
            int option = input.nextInt();
            if (option == 1) {
                login(username, password);
                break;
            } else if (option == 2) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void options(String userName) {
        System.out.println("1. Login");
        System.out.println("2. Exit");
    }

    static void login(String username, String password) {
        System.out.println("Login Successful!");
        ATM.userMenu();
    }
}

class Transactions {
    static void withdrawCash() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter withdrawal amount :");
        int withdrawalAmount = input.nextInt();
        if (withdrawalAmount <= ATM.accountBalance) {
            ATM.accountBalance -= withdrawalAmount;
            ATM.transHistory.add("Withdraw: " + withdrawalAmount);
            System.out.println("Rs." + withdrawalAmount + " withdrawn successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance!");
            System.out.println("---------------------------");
        }
        ATM.userMenu();
    }

    static void depositCash() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter deposit amount :");
        int depositAmount = input.nextInt();
        ATM.updateBalance(depositAmount);
        ATM.transHistory.add("Deposit: " + depositAmount);
        System.out.println("Rs." + depositAmount + " deposited successfully!");
        System.out.println("---------------------------");
        ATM.userMenu();
    }

    static void transfer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the recipient's name:");
        String recipient = input.nextLine();
        System.out.println("Enter the recipient's account number:");
        String recipientAccountNumber = input.nextLine();
        System.out.println("Enter the amount to be transferred :");
        int transferAmount = input.nextInt();
        if (transferAmount <= ATM.accountBalance) {
            ATM.accountBalance -= transferAmount;
            ATM.transHistory.add("Transfer: " + transferAmount + " to " + recipient);
            System.out.println("Rs." + transferAmount + " transferred successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance!");
            System.out.println("---------------------------");
        }
        ATM.userMenu();
    }
}

class AccountCheck {
    static void checkBalance() {
        System.out.println("------------------");
        System.out.println("Available balance:");
        ATM.displayBalance();
        System.out.println("---------------------------");
        ATM.userMenu();
    }
}

class TransactionHistory {
    static void viewHistory() {
        System.out.println("---------------------");
        System.out.println("Transaction History :");
        if (!ATM.transHistory.isEmpty()) {
            for (String record : ATM.transHistory) {
                System.out.println(record);
            }
        } else {
            System.out.println("No transactions found.");
        }
        System.out.println("---------------------------");
        ATM.userMenu();
    }
}

public class ATM {
    public static String userName;
    public static int accountBalance = 0;
    public static String accountNumber;
    public static List<String> transHistory = new ArrayList<>();

    static void updateBalance(int amount) {
        accountBalance += amount;
    }

    static void displayBalance() {
        System.out.println(accountBalance);
    }

    public static void mainMenu() {
        System.out.println("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        System.out.println("WELCOME TO THE ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("Select an option :");
        System.out.println("1. Create Account");
        System.out.println("2. Exit");
        System.out.println("Enter your choice:");
        int choice = input.nextInt();
        if (choice == 1) {
            BankAccount.createAccount();
        } else if (choice == 2) {
            System.exit(0);
        } else {
            System.out.println("Please select a valid option.");
            mainMenu();
        }
    }

    static void userMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("WELCOME " + ATM.userName + "! TO THE ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select an option : ");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Transfer Funds");
        System.out.println("4. Check Balance");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Transactions.withdrawCash();
                break;
            case 2:
                Transactions.depositCash();
                break;
            case 3:
                Transactions.transfer();
                break;
            case 4:
                AccountCheck.checkBalance();
                break;
            case 5:
                TransactionHistory.viewHistory();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                userMenu();
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
