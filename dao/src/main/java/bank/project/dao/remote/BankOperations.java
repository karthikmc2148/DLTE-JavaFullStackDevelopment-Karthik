package bank.project.dao.remote;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.Role;

import java.util.List;
import java.util.Optional;

public interface BankOperations {
  Role getRoleByUserName(String userName);
    List<Customer> getAllCustomers();
    Customer getCustomerByName(String customerName);
    Customer getCustomerById(int customerId);
    List<Loan> getAllLoans();
    Loan getLoanById(int loanAppId);
    Loan getLoanByCustomerId(int customerId);
    String authenticate(String userName, String password);
}

