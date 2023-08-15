import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class CreateAccount {

    private static CreateAccount instance = null;

    private CreateAccount(){
    }

    public void CreateAcc() throws IOException{
        System.out.println("Enter Your Name: ");
        Scanner scanner = new Scanner(System.in);
        String user_Name = scanner.nextLine();
        System.out.println("Enter Password for your Account: ");
        String password = scanner.next();
        System.out.println("Your Account number has been generated.");
        int min = 100000;
        int max = 999999;

        int account_Number = (int) (Math.random() * (max - min + 1)) + min;

        try {
            File file = new File("Account Numbers.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(account_Number));
            bufferedWriter.close();
        }catch (IOException e){
            throw new IOException();
        }

        System.out.println("Here are you account details.");
        System.out.println("User Name: "+ user_Name);
        System.out.println("Password: "+ password);
        System.out.println("Account Number: "+ account_Number);
    }


    public static CreateAccount getInstance(){
        {
            if (instance==null){
                instance = new CreateAccount();
            }
        }
        return instance;
    }


}
