public class BankApp implements BankAppInterface{
    private String userName;
    private String email;
    private String accountNumber;
    private double accountBalance;
    private String password;

    public BankApp(String userName, String email, String accountNumber, double accountBalance, String password){
        this.userName = userName;
        this.email = email;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.password = password;
    }

    @Override
    public void deposit(double amount){

    }

    @Override
    public void transfer(double amount, String accountNumber){

    }

    @Override
    public void withdraw(double amount){

    }


}
