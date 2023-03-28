package student.servlets;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "CurrentAddressServlet",value = "/currentAddress")
public class CurrentAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int registerNumber = Integer.parseInt(request.getParameter("reg"));

        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karthik","Passward@4444");
            String query = "select * from address_mapper, address where reg_number=? and address_id = add_id and address_type='Current Address' ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Address address = new Address();
                address.setDoorNumber(resultSet.getInt("door_number"));
                address.setStreet(resultSet.getString("street"));
                address.setCity(resultSet.getString("city"));
                address.setPinCode(resultSet.getInt("pin_code"));

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("address.jsp");
                request.setAttribute("current", address);
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
