import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean exit = false;

        while (!exit){
            System.out.println("Welcome to banking System");
            System.out.println("Select any option from below");
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Exit");


            Scanner scanner = new Scanner(System.in);
            int Option = scanner.nextInt();

            switch (Option){
                case 1:
                    CreateAccount createAccount = new CreateAccount();
                    createAccount.createaccount();
                    break;
                case 2:
                    Deposit deposit = new Deposit();
                    deposit.deposit();
                    deposit.DepositNow();
                    System.out.println("Hello: "+deposit.getBalance());
                    break;
                case 3:
                    Withdraw withdraw = new Withdraw();
                    withdraw.Withdraw();
                    withdraw.WithDrawNow();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }
}