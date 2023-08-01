import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Requried {


    public static  int newUserOrExsitingUser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.New User!");
        System.out.println("2.Exsisting User!");

        System.out.println("Select the option");
        int newUserOrExsistinUser=sc.nextInt();
        return newUserOrExsistinUser;


    }



    public  static String[] newUser(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter yout password");
        String password=sc.nextLine();
        String[] details= {name,password};
        return details;

    }


    public static int exsistingUser(){
        Scanner sc=new Scanner(System.in);

        System.out.println("1.View products");
        System.out.println("2.View order Hisotry");
        System.out.println("3.Place orders");

        System.out.println("Select your option:");

        int option=sc.nextInt();


        return option ;


    }



    public static void productViewTable(ResultSet resultSet)  throws SQLException{

        while (resultSet.next()){
            System.out.println(resultSet.getInt("productId")+" "+resultSet.getString("productName")+" "+resultSet.getInt("price"));
        }



    }

    public static void Order(ResultSet resultSet, Connection connection, String name) throws SQLException {
        System.out.println("Enter the product name");
        Scanner sc=new Scanner(System.in);
        String  orderOption=sc.nextLine();
        String sqlInsert = "insert into orders values(?,?,?)";

        int count=0;

        int prodId;



        int flag=0;

        while(resultSet.next()){
            count++;
            if(resultSet.getString(2).equals(orderOption)){
                prodId=resultSet.getInt("productId");
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
                preparedStatement.setInt(1, count + 1);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3, prodId);

                int rowsInserted = preparedStatement.executeUpdate();

                if(rowsInserted >0){
                    System.out.println("Inserted");
                    flag=1;
                }
            }

        }

        if(flag == 0) System.out.println("Product not found ");
    }

    public static  void orderHistory(ResultSet resultSet, String name) throws SQLException {

        System.out.println("UserName"+" "+"Product Id");
        while (resultSet.next()){
            if(resultSet.getString(2).equals(name)){
                System.out.print(resultSet.getString(2) +" ");
                System.out.print(resultSet.getInt(3));
            }

//             System.out.println(resultSet.getString(2)+" "+resultSet.getInt(3));

            System.out.println();
        }
    }
}
