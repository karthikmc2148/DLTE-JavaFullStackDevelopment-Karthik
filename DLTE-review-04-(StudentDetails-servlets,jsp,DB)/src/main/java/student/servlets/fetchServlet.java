package student.servlets;

import lombok.SneakyThrows;
import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentResponse", value= "/studentDetails")
public class fetchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","karthik","Passward@4444");
            String query ="select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> studentList = new ArrayList<>();
            Student student = null;
            while(resultSet.next()){
               student = new Student();
               student.setRegister_number(resultSet.getInt("register_number"));
               student.setName(resultSet.getString("student_name"));
               student.setAge(resultSet.getInt("student_age"));
               student.setEmail(resultSet.getString("student_email"));
               studentList.add(student);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("fetchStudent.jsp");
            request.setAttribute("studentDB",studentList);
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//