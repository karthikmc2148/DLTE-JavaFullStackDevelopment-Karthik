package student.servlets;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteServlet" ,value="/delete" )
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int registerNumber = Integer.parseInt(request.getParameter("reg"));
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","karthik","Passward@4444");
            String query = "select add_id from address_mapper where reg_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                arrayList.add(resultSet.getInt("add_id"));
            }
           query= "delete from address_mapper where reg_number=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            int ack1= preparedStatement.executeUpdate();

            query= "delete from student where register_number=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            int ack3= preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("delete from address where address_id in (?,?)");
            preparedStatement.setInt(1, arrayList.get(0));
            preparedStatement.setInt(2,arrayList.get(1));
            int ack2 = preparedStatement.executeUpdate();
            if(ack1>0 && ack2>0 && ack3>0) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentDetails");
                PrintWriter printWriter = response.getWriter();
                printWriter.println("Deleted the student record successfully!!");
                requestDispatcher.forward(request, response);
            }
            else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentDetails");
                    request.setAttribute("deleted","Deletion not performed");
                    requestDispatcher.forward(request,response);
                    //requestDispatcher.forward(request, response);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
