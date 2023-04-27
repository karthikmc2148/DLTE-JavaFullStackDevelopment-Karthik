package bank.project.dao.service;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.LoanScheme;
import bank.project.dao.model.Role;
import bank.project.dao.remote.BankOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class BankService implements BankOperations {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("originBank");
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //logger for service class using SLF4J
    private Logger logger = LoggerFactory.getLogger(BankService.class);

    @Override
    // provides the role object based on userName
    public Role getRoleByUserName(String userName) {
        try {
            Role role = jdbcTemplate.queryForObject("select * from role where username=?", new Object[]{userName}, new BeanPropertyRowMapper<>(Role.class));
            logger.info("role object is returned using username");
            return role;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
        @Override
        //provides the list of customer objects
    public List<Customer> getAllCustomers() {
        logger.info("customer list is received");
        return jdbcTemplate.query("select * from customer", new CustomerMapper());
    }

    @Override
    //provides the customer object based on userName
    public Customer getCustomerByUserName(String userName) {
        try {

            Customer customer = jdbcTemplate.queryForObject("select * from customer where username=?", new Object[]{userName}, new BeanPropertyRowMapper<>(Customer.class));
           logger.info("customer object is received");
            return customer;
        } catch (DataAccessException e) {
            return  null;
        }
    }

    @Override
    //provides the customer object based on customerId
    public Customer getCustomerById(int customerId) {
        try {
            logger.info("customer object is received using customerId");
            Customer customer = jdbcTemplate.queryForObject("select * from customer where customer_id=?", new Object[]{customerId}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
        } catch (DataAccessException e) {
            return null;
        }
    }
    @Override
    //provides the list of loan objects
    public List<Loan> getAllLoans() {
        logger.info("Service is invoked!!");
        List<Loan> loanList = jdbcTemplate.query("select * from loan", new LoanMapper());
        logger.info(loanList.toString() + "returned value");
        return loanList;
    }

    @Override
    //method that authenticates, weather the admin or Bank official credential's are valid
    public String authenticateAdminOrBanker(String userName, String password) {
        Role role = getRoleByUserName(userName);
        if (role == null) {
            logger.info("user Not Found!!");
            return resourceBundle.getString("notFound");
        }
        else {
            if (role.getRoleStatus().equalsIgnoreCase("Inactive")) {
                logger.info(userName + ": is deactivated!!");
                return resourceBundle.getString("deactivated");
            }
            else if (!password.equals(role.getPassword())) {
                incrementFailedAttemptsToAdminOrBanker(userName);
                logger.info("Invalid Password:"+userName);
                return resourceBundle.getString("invalidPassword");
            } else
                setDefaultAttemptsToAdminOrBanker(userName);
                 logger.info("Successfully Logged in!! :"+userName);
                return resourceBundle.getString("loginSuccess");
        }
    }

    @Override
    //method that authenticates, weather the admin or Bank official credential's are valid
    public String authenticateCustomer(String userName, String password) {
         Customer customer = getCustomerByUserName(userName);
        if (customer == null) {
            logger.info("user Not Found!!");
            return resourceBundle.getString("notFound");
        }else {
            if (customer.getCustomerStatus().equalsIgnoreCase("Inactive")) {
                logger.info(userName + ": is deactivated!!");
                return resourceBundle.getString("deactivated");
            } else if (!password.equals(customer.getPassword())) {
                incrementFailedAttemptsToCustomer(userName);
                logger.info("Invalid Password:"+userName);
                return resourceBundle.getString("invalidPassword");
            } else
                setDefaultAttemptsToCustomer(userName);
            logger.info("Successfully Logged in!! :"+userName);
            return resourceBundle.getString("loginSuccess");
        }
    }

    @Override
    //provides the list of LoanScheme Objects
    public List<LoanScheme> getAllLoanScheme() {
        logger.info("loan scheme list is received");
        return jdbcTemplate.query("select * from loan_scheme", new LoanSchemeMapper());
    }
     //increments the Failed attempts for invalid password and deactivates the user if attempts=3
    public void incrementFailedAttemptsToAdminOrBanker(String userName){
        logger.error("Updating the Failed Attempts of admin or banker:"+userName);
        jdbcTemplate.update("update role set failed_attempts=failed_attempts+1 where username=?",userName);
        logger.error("deactivating the accounts for Failed attempts=3");
        jdbcTemplate.update("update role set role_status='inactive' where failed_attempts=3");
    }
    //increments the Failed attempts for invalid password and deactivates the user if attempts=3
    public void incrementFailedAttemptsToCustomer(String userName){
        logger.error("Updating the Failed Attempts of customer"+userName);
        jdbcTemplate.update("update customer set failed_attempts=failed_attempts+1 where username=?",userName);
        logger.error("deactivating the accounts for Failed attempts=3");
        jdbcTemplate.update("update customer set customer_status='inactive' where failed_attempts=3");
    }
    //on successful login reset the attempts of specific user to zero in role object
    public void setDefaultAttemptsToAdminOrBanker(String userName){
        jdbcTemplate.update("update role set failed_attempts=0 where username=?", userName);
        logger.info("reset the failed attempts to admin or banker:"+userName);
    }
    //on successful login reset the attempts of specific user to zero in role object
    public void setDefaultAttemptsToCustomer(String userName){
        jdbcTemplate.update("update role set failed_attempts=0 where username=?", userName);
        logger.info("reset the failed attempts to Customer:"+userName);
    }
    // class that provides the all the records in Loan table
    class LoanMapper implements RowMapper<Loan> {

        @Override
        public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loan loan = new Loan();
            logger.info("A new loan object created");
            loan.setLoanAppId(rs.getInt("loan_App_id"));
            loan.setLoanAmount(rs.getDouble("loan_amount"));
            loan.setLoanEmi(rs.getDouble("loan_emi"));
            loan.setCustomerId(rs.getInt("customer_id"));
            loan.setLoanSchemeId(rs.getInt("loan_scheme_id"));
            logger.info(" Loan object is Ready to view");
            return loan;
        }
    }
    // class that provides the all the records in customer table .
    class CustomerMapper implements RowMapper<Customer>{

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            logger.info("A new Customer object created");
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerAddress(rs.getString("customer_address"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerStatus(rs.getString("customer_status"));
            customer.setCustomerContact(rs.getLong("customer_contact"));
            customer.setUserName(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            logger.info(" customer object is Ready to view");
            return customer;
        }
    }
    // class that provides the all the records in role table
    class RoleMapper implements RowMapper<Role>{
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            logger.info("A new Role object created");
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setRoleDescription(rs.getString("role_desc"));
            role.setRoleStatus(rs.getString("role_status"));
            role.setBranchId(rs.getInt("branch_id"));
            role.setUsername(rs.getString("username"));
            role.setPassword(rs.getString("password"));
            role.setFailedAttempts(rs.getInt("failed_attempts"));
            logger.info(" role object is Ready to view");
            return role;
        }
    }
    // class that provides the all the records in loanScheme table
    class LoanSchemeMapper implements RowMapper<LoanScheme> {

        @Override
        public LoanScheme mapRow(ResultSet rs, int rowNum) throws SQLException {
            LoanScheme loanScheme = new LoanScheme();
            logger.info("A new Loan Scheme object created");
            loanScheme.setLoanSchemeId(rs.getInt("loan_scheme_id"));
            loanScheme.setLoanSchemeType(rs.getString("loan_scheme_type"));
            loanScheme.setLoanSchemeName(rs.getString("loan_scheme_name"));
            loanScheme.setLoanSchemeDescription(rs.getString("loan_scheme_desc"));
            loanScheme.setLoanSchemeRoi(rs.getFloat("loan_scheme_roi"));
            logger.info(" Loan Scheme object is Ready to view");
            return loanScheme;
        }
    }
}