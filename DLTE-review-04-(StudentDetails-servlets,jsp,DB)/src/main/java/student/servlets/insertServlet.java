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
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

@WebServlet(name = "insertServlet" ,value = "/insert")
public class insertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO,"the Details are about Store in the server");
       int  registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
       String studentName = request.getParameter("studentName");
        int  studentAge = Integer.parseInt( request.getParameter("studentAge"));
        String studentEmail = request.getParameter("studentEmail");
        logger.log(Level.INFO, "student details are received");

        int  doorNo1 = Integer.parseInt(request.getParameter("doorNo1"));
        String street1 = request.getParameter("street1");
        String city1 = request.getParameter("city1");
        int pinCode1 = Integer.parseInt(request.getParameter("pinCode1"));
        logger.log(Level.INFO, "Current Address details are received");

        int  doorNo2 = Integer.parseInt(request.getParameter("doorNo2"));
        String street2 = request.getParameter("street2");
        String city2 = request.getParameter("city2");
        int pinCode2 = Integer.parseInt(request.getParameter("pinCode2"));
        logger.log(Level.INFO, "Permanent Address details are received");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println(registerNumber+studentName+studentAge+studentEmail+doorNo1+street1+city1+pinCode1+doorNo2+street2+city2+pinCode2);

        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","karthik","Passward@4444");
             String query = "insert into student values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            preparedStatement.setString(2,studentName);
            preparedStatement.setInt(3,studentAge);
            preparedStatement.setString(4,studentEmail);
            //preparedStatement.execute();
            int acknowledgment1 = preparedStatement.executeUpdate();
            logger.log(Level.INFO,"student details inserted into DB");

             query = "insert into address values(address_id.NEXTVAL,?,?,?,?,?)";
             preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doorNo1);
            preparedStatement.setString(2,street1);
            preparedStatement.setString(3,city1);
            preparedStatement.setInt(4,pinCode1);
            preparedStatement.setString(5,"Current Address");
            int acknowledgment2 = preparedStatement.executeUpdate();
            logger.log(Level.INFO,"Current Address details inserted into DB");

             query = "insert into address_mapper values(?,address_id.CURRVAL)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            //preparedStatement.execute();
            int acknowledgment3 = preparedStatement.executeUpdate();

            query= "insert into address values(address_id.NEXTVAL,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doorNo2);
            preparedStatement.setString(2,street2);
            preparedStatement.setString(3,city2);
            preparedStatement.setInt(4,pinCode2);
            preparedStatement.setString(5,"Permanent Address");
            int acknowledgment4 = preparedStatement.executeUpdate();
            logger.log(Level.INFO,"Permanent Address details inserted into DB");

            query = "insert into address_mapper values(?,address_id.CURRVAL)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,registerNumber);
            //preparedStatement.execute();
            int acknowledgment5 = preparedStatement.executeUpdate();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            if(acknowledgment1>0 && acknowledgment2>0 && acknowledgment3 >0 && acknowledgment4>0 && acknowledgment5>0) {
                logger.log(Level.FINE, "student details inserted Successfully!!");
                request.setAttribute("information", "Student Details registerd in DB");
                requestDispatcher.forward(request,response);
            }
            else {
                logger.log(Level.WARNING,"Student Details not inserted");
                request.setAttribute("information", "Student details not registered!!");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
