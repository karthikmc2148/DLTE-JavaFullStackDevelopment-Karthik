package Loan;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Operations operations = new Operations();
        System.out.println(operations.loginMethod("Karthik",2023));

    }
}
