import java.sql.*;

public class JdbcMethods{
    public static String[] details = Requried.newUser();

    public static String name;

    public static void register(Connection connection, Statement statement, ResultSet resultSet, int count, int flag) throws SQLException {


        while (resultSet.next()) {
            count++;

            if (resultSet.getString("Name").equals(details[0])) {
                System.out.println("User name already exsists");
                flag = 1;
                break;
            }
        }


        if (flag == 1) {
            JdbcConnection.jdbcConnection();

        }
        if (flag == 0) {
            String sqlInsert = "insert into users values(?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
                preparedStatement.setInt(1, count + 1);
                preparedStatement.setString(2, details[0]);
                preparedStatement.setString(3, details[1]);
                name=details[0];
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("You're signed In!");
                   int option=Requried.exsistingUser();

                    if(option ==1){
                        resultSet=statement.executeQuery("select * from products");
                        Requried.productViewTable(resultSet);
                    }

                    else if(option ==3)
                    {
                        resultSet = statement.executeQuery("select * from products");
                        Requried.Order(resultSet,connection,name);
                    }



                } else {
                    System.out.println("Error 404");
                    UserCreatingMethods.newUserCreatingError();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }


    }

    public static void exsistingUser(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        int flag = 0;
        while (resultSet.next()) {
            if (resultSet.getString("Name").equals(details[0]) && resultSet.getString("password").equals(details[1])) {

                name=resultSet.getString("Name");
                System.out.println("Signed Up!");

                int option=Requried.exsistingUser();

                if(option ==1){
                    resultSet=statement.executeQuery("select * from products");
                    Requried.productViewTable(resultSet);
                }

                else if(option ==2){
                    resultSet=statement.executeQuery("select * from orders");
                    Requried.orderHistory(resultSet,name);
                }
                else if(option ==3)
                {
                    resultSet = statement.executeQuery("select * from products");

                    Requried.Order(resultSet,connection,name);


                }

                flag = 1;
                break;
            }


        }
        if (flag == 0) {
            System.out.println("I qqrd");
        }


    }


}
