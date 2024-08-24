import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
      if (amount > 0) {
        balance += amount;
      }   
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
class ATM {
    private BankAccount account;

    public ATM(BankAccount account){
        this.account = account;
    }
    public void displayMenu() {
   System.out.println("Welcome to the ATM!");
   System.out.println("1. Withdraw");
   System.out.println("2. Deposit");
   System.out.println("3. Check Balance");
   System.out.println("4. Exit");     
    }
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if(account.withdraw(amount)) {
            System.out.println("Withdraw successful: Your New Balance is: Rs" + account.getBalance());
        } else
        System.out.println("Insufficient balance!");
    }
        public void deposit() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter amount to deposit: ");
         double amount = scanner.nextDouble();
         account.deposit(amount);
         System.out.println("Deposit successful: Your New Balance is: Rs" + account.getBalance());   

        }
        public void checkBalance() {
            System.out.println("Your current balance is: Rs" + account.getBalance());
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                displayMenu();
                System.out.println("Choose an option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                    withdraw();
                    break;
                    case 2:
                    deposit();
                    break;
                    case 3:
                    checkBalance();
                    break;
                    case 4:
                    System.out.println("Thankyou for using the ATM. Have a nice day!");
                    scanner.close();
                    return;
                    default:
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
    public class ATMDemo {
        public static void main(String[] args) {
            BankAccount account = new BankAccount(5000.00);
            ATM atm = new ATM(account);
            atm.start();
        }
    }
