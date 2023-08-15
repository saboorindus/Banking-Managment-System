import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean exit = false;
        System.out.println("\nWelcome to banking Systemn\n");

        while (!exit){

            System.out.println("Select any option from below");
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Exit");


            Scanner scanner = new Scanner(System.in);
            int Option = scanner.nextInt();

            switch (Option) {
                case 1 -> {
                    CreateAccount createAccount = CreateAccount.getInstance();
                    createAccount.CreateAcc();
                }
                case 2 -> {
                    Deposit deposit = Deposit.getInstance();
                    deposit.deposit();
                    deposit.DepositNow();
                }
                case 3 -> {
                    Withdraw withdraw = Withdraw.getInstance();
                    withdraw.withdraw();
                    withdraw.WithDrawNow();
                }
                case 4 -> {
                    exit = true;
                    scanner.close();
                }
            }

        }
    }

}