class Account {
    int accountNumber;

    void showAccount() {
        System.out.println("Account Number: " + accountNumber);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    void showSavingsDetails() {
        System.out.println("Interest Rate: " + interestRate);
    }
}

class FixedDepositAccount extends SavingsAccount {
    int lockInYears;

    void showFDDetails() {
        System.out.println("Lock-in Years: " + lockInYears);
    }
}

public class Multilevel {
    public static void main(String[] args) {

        FixedDepositAccount fd = new FixedDepositAccount();

        fd.accountNumber = 101;
        fd.interestRate = 5.5;
        fd.lockInYears = 2;

        fd.showAccount();
        fd.showSavingsDetails();
        fd.showFDDetails();
    }
}