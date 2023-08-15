import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Deposit extends CreateAccount{

    private int Balance = 0;
    boolean accountFound = false;


    Scanner scanner = new Scanner(System.in);
    public void deposit() {
        while (!accountFound){
            System.out.println("Enter you account number");
            int newAccountNumber = scanner.nextInt();
            try {
                File file = new File("Account Numbers.txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    int accountNumberFromFile = Integer.parseInt(line);
                    if (accountNumberFromFile == newAccountNumber) {
                        System.out.println("Account Found");
                        bufferedReader.close();
                        accountFound = true;
                        break;
                }
                    System.out.println("Account Not Found \nTry Again");
                }
            }catch (IOException e){
                System.out.println("Try Again");
            }
        }
    }

    public int DepositNow(){
        CreateAccount createAccount = new CreateAccount();
        boolean perfect = false;
        while (!perfect) {
            System.out.println("Enter Amount to deposit");
            int newBalance = scanner.nextInt();
            if (newBalance >= 100) {
                Balance = Balance + newBalance;
                System.out.println("Balance Deposit Complete");
                System.out.println("Your new Balance is: " + Balance);
                perfect = true;
            } else {
                System.out.println("Balance must be greater than 100");
            }
        }
        return Balance;
    }

     public int getBalance(){
         return Balance;
     }

}
