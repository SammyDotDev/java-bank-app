import Models.TransactionRecord;
import Models.User;
import helpers.Helpers;

import java.io.Console;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Helpers {

    public static void register() throws Exception {
        Console cons;
        Set<User> users = loadUserData();
        System.out.println(users);
        Set<User> userSet = new HashSet<>(users);

        System.out.print("Enter a username: ");
        Scanner scanner = new Scanner(System.in);
        String userName = formatString(scanner.nextLine());

        while (userName.isEmpty()){
            System.out.println("Invalid username. Please try again");
            System.out.print("Enter a username: ");
            userName = formatString(scanner.nextLine());
        }

//        for(int i = 0; i < users.length; i++){
//            System.out.println(users[i]);
//        }

        System.out.print("Enter an email address: ");
        String email = formatString(scanner.nextLine());

        while (email.isEmpty()){
            System.out.println("Invalid email address. Please try again");
            System.out.print("Enter an email address: ");
            email = formatString(scanner.nextLine());
        }

        while(!validateEmail(email)){
            System.out.println("Invalid email address format. Please try again");
            System.out.print("Enter an email address: ");
            email = formatString(scanner.nextLine());
        }

        System.out.print("Enter a password: ");
        char[] psswd = null;
        if ((cons = System.console())!= null &&
                (psswd = cons.readPassword("[%s]", "Enter a Password:")) != null){
            java.util.Arrays.fill(psswd, ' ');
        }
        assert psswd != null;
        System.out.println(psswd);
        String password = formatString(scanner.nextLine());

        while (password.isEmpty()){
            System.out.println("Invalid password. Please try again!");
            System.out.print("Enter a password: ");
            password = formatString(scanner.nextLine());
        }
        System.out.print("Confirm password: ");
        String confirmPassword = formatString(scanner.nextLine());

        while (!password.equals(confirmPassword)){
            System.out.println("Passwords do not match!");
            System.out.print("Confirm password: ");
            confirmPassword = formatString(scanner.nextLine());
        }

        String accountNumber = generateAccountNumber();
        double accountBalance = 0.0;

        int transactionPin;
        while(true){
            try{
                System.out.print("Please enter a 4 digit transaction pin: ");
                transactionPin = Integer.parseInt(formatString(scanner.nextLine()));
                while (transactionPin < 1000 || transactionPin > 9999){
                    System.out.print("Invalid pin!. Please enter a 4 digit pin: ");
                    transactionPin = Integer.parseInt(formatString(scanner.nextLine()));
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid pin!. Please input a 4 digit numeric character");
            }
        }

//        TransactionRecord transactionRecord = null;

        User newUser = new User(userName, email, password, accountNumber, accountBalance, transactionPin);
        userSet.add(newUser);
        saveUserData(userSet);
    }

    public static void main(String[] args) throws Exception {
        List<String> answers = new ArrayList<>(2);
        answers.add("yes");
        answers.add("no");
        System.out.println("-------------WELCOME TO THE BANK APP---------------");
        System.out.print("Are you a new user?. (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String userPrompt = formatString(scanner.nextLine());

        while (userPrompt.isEmpty()){
            System.out.println("Invalid input, please try again");
            System.out.print("Are you a new user?. (yes/no): ");
            userPrompt = formatString(scanner.nextLine());
        }

        while(!answers.contains(userPrompt)){
            System.out.println("Invalid input, please try again");
            System.out.print("Are you a new user?. (yes/no): ");
            userPrompt = formatString(scanner.nextLine());
        }

        if(userPrompt.equals("yes")){
            System.out.println("------------------CREATE A NEW ACCOUNT------------------");
            register();
        }else if (userPrompt.equals("no")){
            System.out.println("------------------WELCOME BACK------------------");
        }
    }
}