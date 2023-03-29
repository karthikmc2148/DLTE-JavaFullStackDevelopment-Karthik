package Loan;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;

public class Operations {
    private Driver driver;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;
    private Connection connection;

    public Operations() {
        try {
            driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:xe", "karthik", "Passward@4444");
            System.out.println("Successfully Connected to Oracle DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    method that validates the login Details
    public String loginMethod(String customerName, int pin) throws SQLException {
        query = "select * from customer where customer_name=? and pin=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customerName);
        preparedStatement.setInt(2, pin);
        int ack = preparedStatement.executeUpdate();
        if (ack > 0) {
            return customerName;
        } else
            return "Inavalid Login Credentails";
    }
    public ArrayList<Loan> getLoanDetails(int customerId){
        query = "select * from loan outer right join loan_mapper on loan_number=loan_id";
    return
    }
}