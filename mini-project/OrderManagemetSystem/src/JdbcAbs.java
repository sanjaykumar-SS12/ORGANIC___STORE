import java.sql.Connection;
import java.sql.ResultSet;

public interface JdbcAbs  {

     int newUserOrExsitingUser();
     String[] newUser();
     int exsistingUser();
     void productViewTable(ResultSet resultSet);

     void Order(ResultSet resultSet, Connection connection, String name);
     void orderHistory(ResultSet resultSet, String name);
}