package Models;

public class User {
    private double id;
    private String userName;
    private String email;
    private  String password;
    private String accountNumber;
    private double accountBalance;
    private int transactionPin;
//    private TransactionRecord transactionRecord;

    public User(){

    }

    public User(String userName, String email, String password, String accountNumber, double accountBalance, int transactionPin){
        this.id = Math.random();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.transactionPin = transactionPin;
//        this.transactionRecord = transactionRecord;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    public int getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(int transactionPin) {
        this.transactionPin = transactionPin;
    }
}
