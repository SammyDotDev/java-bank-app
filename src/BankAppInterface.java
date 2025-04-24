public interface BankAppInterface {

    void deposit(double amount);

    void transfer(double amount, String accountNumber);

    void withdraw(double amount);
}
