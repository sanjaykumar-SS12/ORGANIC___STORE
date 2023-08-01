import java.util.Scanner;

public class UserCreatingMethods {


    public static void newUserCreatingError(){
        System.out.println("1.Signin Again");
        System.out.println("2.Menu Again");
        System.out.println("3.Exit");

        Scanner sc=new Scanner(System.in);

        int option=sc.nextInt();

        if(option == 1)  {
            JdbcConnection.jdbcConnection();
        }
        else if(option == 2) {
            Requried requried=new Requried();

            requried.newUserOrExsitingUser();
        }
    }




}
