package bank.project.dao.remote;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.LoanScheme;
import bank.project.dao.model.Role;

import java.util.List;


public interface BankOperations {
  //returns role object of desired object
  Role getRoleByUserName(String userName);

  //display customer details and customer_search
    List<Customer> getAllCustomers();
    Customer getCustomerByUserName(String customerName);
    Customer getCustomerById(int customerId);

    //Display Loan details
    List<Loan> getAllLoans();

// admin and customer login
    String authenticateAdminOrBanker(String userName, String password);
  String authenticateCustomer(String userName, String password);

  //loan_Scheme search
  List<LoanScheme> getAllLoanScheme();
}

