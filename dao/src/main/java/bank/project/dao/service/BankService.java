package bank.project.dao.service;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.Role;
import bank.project.dao.remote.BankOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    private Logger logger = LoggerFactory.getLogger(BankService.class);

    @Override
    public Role getRoleByUserName(String userName) {
        logger.info("role object is returned using username");
         return jdbcTemplate.queryForObject("select * from role where username=?", new RoleMapper(), userName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        logger.info("customer list is received");
        return jdbcTemplate.query("select * from customer", new CustomerMapper());
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        try {

            Customer customer = jdbcTemplate.queryForObject("select * from customer where CUSTOMER_NAME=?", new CustomerMapper(), customerName);
            logger.info("customer object is received using customerName");
            return customer;
        } catch (DataAccessException e) {
            return  null;
        }
    }

    @Override
    public Customer getCustomerById(int customerId) {
        try {
            logger.info("customer object is received using customerId");
            Customer customer = jdbcTemplate.queryForObject("select * from customer where CUSTOMER_ID=?", new CustomerMapper(), customerId);
        return customer;
        } catch (DataAccessException e) {
            return null;
        }
    }
    @Override
    public List<Loan> getAllLoans() {
        logger.info("Service is invoked!!");
        List<Loan> loanList = jdbcTemplate.query("select * from loan", new LoanMapper());
        logger.info(loanList.toString() + "returned value");
        return loanList;
    }

    @Override
    public Loan getLoanById(int loanAppId){
        try {
            Loan loan = jdbcTemplate.queryForObject("select * from loan where LOAN_APP_ID=?", new LoanMapper(), loanAppId);
            logger.info(" Loan object is returned");
            return loan;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public Loan getLoanByCustomerId(int customerId) {
        try {
            Loan loan = jdbcTemplate.queryForObject("select * from loan where CUSTOMER_ID=?", new LoanMapper(), customerId);
            logger.info(" Loan object is returned");
            return loan;
        } catch (DataAccessException e) {
            logger.info("Loan record not found!!");
            return null;
        }
    }
    @Override
    public String authenticate(String userName, String password) {
        Role role = getRoleByUserName(userName);
        if (role == null)
            return resourceBundle.getString("notFound");
        else {
            if (role.getRoleStatus().equalsIgnoreCase("Inactive"))
                return resourceBundle.getString("deactivated");
            else if (!password.equals(role.getPassword())) {
                incrementfailedAttempts(userName);
                return resourceBundle.getString("invalidPassword");
            } else
                setDefaultAttempts(userName);
                return resourceBundle.getString("loginSuccess");
        }
    }
    public void incrementfailedAttempts(String userName){
        logger.error("Updating the Failed Attempts");
        jdbcTemplate.update("update role set failed_attempts=failed_attempts+1 where username=?",userName);
        logger.error("deactivating the accounts for Failed attempts=3");
        jdbcTemplate.update("update role set role_status='inactive' where failed_attempts=3");
//        logger.info(userName + resourceBundle.getString("deactivated"));
    }
    public void setDefaultAttempts(String userName){
        jdbcTemplate.update("update role set failed_attempts=0 where username=?", userName);
    }

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

    class CustomerMapper implements RowMapper<Customer>{

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerAddress(rs.getString("customer_address"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerStatus(rs.getString("customer_status"));
            customer.setCustomerContact(rs.getLong("customer_contact"));
            customer.setUserName(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            return customer;
        }
    }
    class RoleMapper implements RowMapper<Role>{
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setRoleDescription(rs.getString("role_desc"));
            role.setRoleStatus(rs.getString("role_status"));
            role.setBranchId(rs.getInt("branch_id"));
            role.setUsername(rs.getString("username"));
            role.setPassword(rs.getString("password"));
            role.setFailedAttempts(rs.getInt("failed_attempts"));
            return role;
        }
    }
}