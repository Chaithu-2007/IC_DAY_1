class BankAccount {
    private String accountHolder;
    private double balance;

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
}

public class Ba {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();

        b.setAccountHolder("Chaithanya");
        b.setBalance(5000);

        System.out.println("Account Holder: " + b.getAccountHolder());
        System.out.println("Balance: " + b.getBalance());

        b.setBalance(-1000);
        System.out.println("Balance: " + b.getBalance());

        b.deposit(2000);
        System.out.println("Balance: " + b.getBalance());

        b.withdraw(8000);
        System.out.println("Balance: " + b.getBalance());

        b.withdraw(1000);
        System.out.println("Final Balance: " + b.getBalance());
    }
}