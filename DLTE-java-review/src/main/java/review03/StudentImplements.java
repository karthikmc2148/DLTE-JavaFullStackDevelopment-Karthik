package review03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.jdbc.OracleDriver;

import java.sql.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentImplements implements StudentInterface {
    private Driver driver;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;
    private Connection connection;

    public void jdbcConnection() throws SQLException {
        driver = new OracleDriver();
        DriverManager.registerDriver(driver);
       connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Passward@4444");
       System.out.println("Successfully connected to Oracle DB");
    }


    @Override
    public void insert(Student student,Address address) throws SQLException {
        setQuery("insert into student values( ?,?,?,?, student_seq.NEXTVAL");
        preparedStatement = connection.prepareStatement(getQuery());
        preparedStatement.setInt(1,student.getRegister_number());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.executeQuery();
        int x = preparedStatement.executeUpdate();
        setQuery("insert into address values(address_seq.CURVAL,?,?,?,?");
        preparedStatement  = connection.prepareStatement(getQuery());
        preparedStatement.setString(1,address.getLocality());
        preparedStatement.setString(2,address.getArea());
        preparedStatement.setString(3,address.getCity());
        preparedStatement.setInt(4,address.getPin());
        int y = preparedStatement.executeUpdate();
        if(x>0 && y>0)
            System.out.println("Student Details Inserted into DB Sucessfully!!");
            else
                System.out.println("Student Details not inserted");
    }

    @Override
    public void viewDetails() throws SQLException {
        setQuery("Select * from student, address where address_id = add_id");
        preparedStatement = connection.prepareStatement(getQuery());
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("register_number")+" "+resultSet.getString("student_name")+" "+resultSet.getInt("student_age")+" "+resultSet.getString("student_email")+" "+" "+resultSet.getString("locality")+" "+resultSet.getString("area")+" "+resultSet.getString("city")+" "+resultSet.getInt("pincode"));
        }
    }


    @Override
    public void delete(int  reg_no) throws SQLException {
     setQuery("delete from students where register_number = ?");
     preparedStatement = connection.prepareStatement(getQuery());
     resultSet = preparedStatement.executeQuery();
     if(preparedStatement.executeUpdate()>0)
         System.out.println("Deleted Successfully!!");
     else System.out.println("Deletion not performed");
    }
}
