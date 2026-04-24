// Custom Exception Class
class LessBalanceException extends Exception {
    public LessBalanceException(double amount) {
        super("Withdraw amount (Rs " + amount + ") is not valid. Insufficient balance.");
    }
}

// Bank Account Class
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) throws LessBalanceException {
        if (initialBalance < 1000) {
            throw new LessBalanceException(initialBalance);
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    public void withdraw(double amount) throws LessBalanceException {
        if (balance - amount < 1000) {
            throw new LessBalanceException(amount);
        }
        balance -= amount;
        System.out.println("Withdrew: Rs " + amount);
    }

    public void displayBalance() {
        System.out.println("Account " + accountNumber + " Balance: Rs " + balance);
    }
}

// Demonstration Class
public class BankingDemo {
    public static void main(String[] args) {
        try {
            // Create account with minimum balance
            BankAccount account = new BankAccount("ACC1001", 5000);
            account.displayBalance();

            // Perform transactions
            account.deposit(2000);
            account.displayBalance();

            account.withdraw(5500); // valid
            account.displayBalance();

            account.withdraw(3000); // should throw LessBalanceException

        } catch (LessBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Demonstrate ArithmeticException
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: Division by zero is not allowed!");
        }
    }
}
