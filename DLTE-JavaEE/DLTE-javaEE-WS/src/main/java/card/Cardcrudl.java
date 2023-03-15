package card;

import oracle.jdbc.OracleDriver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Cardcrudl {
   private Driver driver;
   private Connection connection;
   private String query;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;
 Credit_card credit_card = new Credit_card();
   public void cardcrudl() {
       driver = new OracleDriver();
       try {
           DriverManager.registerDriver(driver);
           connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Passward@4444");
           System.out.println("Successfully connected to JDBC");
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

  @WebMethod
    public ListCards Display()  {
       ListCards listCards = new ListCards();
       query = "Select * from credit_card";
      try {
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
              Credit_card credit_card = new Credit_card();
              credit_card.setCard_number(resultSet.getInt("card_number"));
              credit_card.setCard_holder(resultSet.getString("card_holder"));
              credit_card.setCard_pin(resultSet.getInt("card_pin"));
              credit_card.setCard_expiry(resultSet.getDate("card_expiry"));
              credit_card.setCard_limit(resultSet.getDouble("card_limit"));
              listCards.getCards().add(credit_card);
          }
          return listCards;
      } catch (SQLException e) {
          e.printStackTrace();
      }
     return null;
  }
  @WebMethod
  public String delete(@WebParam(name = "cardNumber") Integer cardNumber ) {

       query = "delete from credit_card where card_number = cardNumber";
      try {
          preparedStatement = connection.prepareStatement(query);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      int ack = 0;
      try {
          ack = preparedStatement.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      if(ack>0)
           return credit_card.getCard_holder()+" has been deleted";
       else
           return credit_card.getCard_holder()+ " has not found in the records";
   }
}
