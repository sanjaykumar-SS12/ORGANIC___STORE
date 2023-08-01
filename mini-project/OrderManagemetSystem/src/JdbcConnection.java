import java.sql.*;

public class JdbcConnection {

    private   static String url="jdbc:mysql://localhost:3306/OrderManagmentSystem";
    private static String user="root";
    private static String password="Overdrive@07";

    private static int count=0;
    private static int flag=0;

    public static JdbcConnection jdbcConnection() {
        Requried requried=new Requried();

        int option = requried.newUserOrExsitingUser();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            if (option == 1) {
                JdbcMethods.register(connection, statement, resultSet, count, flag);

            }
            if(option ==2 ){
                JdbcMethods.exsistingUser(connection, statement, resultSet);
            }
            connection.close();

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
