import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
public class Withdraw {

    private static Withdraw instance = null;
    boolean accountFound = false;
    Scanner scanner = new Scanner(System.in);


    private Withdraw(){}
    public void withdraw(){
        while (!accountFound) {
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
                        accountFound = true;
                        bufferedReader.close();
                        break;
                    }
                    System.out.println("Account Not Found \nTry Again");
                }
            } catch (IOException e) {
                System.out.println("Try Again");
            }
        }
    }

    public void WithDrawNow(){
        Deposit deposit = Deposit.getInstance();
        int Balance = deposit.getBalance();
        System.out.println(deposit.getBalance());
        System.out.println("Enter Amount to Withdraw");
        int newBalance = scanner.nextInt();

        boolean perfect = false;
        while (!perfect) {
            if (newBalance>99){
                if (newBalance<=Balance){
                    Balance = Balance - newBalance;
                    System.out.println("Withdraw Complete of: "+newBalance);
                    System.out.println("Your New Balance is: "+Balance);
                    perfect = true;
                } else {
                    System.out.println("Not Enough Balance \nYour Current Balance is: "+deposit.getBalance());
                 }
            } else {
                System.out.println("Balance must be greater than 99");
             }

        }
    }

    public static Withdraw getInstance() {
        if (instance == null) {
            instance = new Withdraw();
        }
        return instance;

    }
}


