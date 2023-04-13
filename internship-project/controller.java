package bank.project.dao.control;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping("/AllLoans")
    public List<Loan> callingGetAllLoans(){
        return bankService.getAllLoans();
    }
    @GetMapping("/AllCustomers")
    public List<Customer> callingAllCustomers(){
        return bankService.getAllCustomers();
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerStatus;
    private int customerContact;
    private String userName;
    private String password;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private Integer loanSchemeId;
    private int loanAppId;
    private float loanAmount;
    private float loanEmi;
    private int customerId;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int roleId;
    private String roleName;
    private String roleDescription;
    private String roleStatus;
    private int branchId;
    private String username;
    private String password;
}

package bank.project.dao.remote;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.Role;

import java.util.List;
import java.util.Optional;

public interface BankOperations {
    boolean getByUSerName(String userName, String password);
    Role listOne(String userName);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomer(String customerName);
    List<Loan> getAllLoans();
    Optional<Loan> getLoan(int loanAppId);

}

package bank.project.dao.service;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.Role;
import bank.project.dao.remote.BankOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankService implements BankOperations {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean getByUSerName(String userName, String password) {
        Role role = listOne(userName);
        if (role.getUsername() == userName && role.getPassword() == password && role.getRoleStatus() == "active") {
            return true;
        }
        return false;

    }

    @Override
    public Role listOne(String userName) {
        Role role = (Role) jdbcTemplate.query("select * from role where username=?", new Object[]{userName}, new BeanPropertyRowMapper<>(Role.class));
        return role;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("select * from customer", new CustomerMapper());
    }

    @Override
    public Optional<Customer> getCustomer(String customerName) {
        return Optional.empty();
    }

    @Override
    public List<Loan> getAllLoans() {

        return jdbcTemplate.query("select * from loan", new LoanMapper());
    }

    @Override
    public Optional<Loan> getLoan(int loanAppId) {
        return Optional.empty();
    }


    public class LoanMapper implements RowMapper<Loan> {

        @Override
        public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loan loan = new Loan();
            loan.setLoanAppId(rs.getInt("loan_App_id"));
            loan.setLoanAmount(rs.getFloat("loan_amount"));
            loan.setLoanEmi(rs.getFloat("loan_emi"));
            loan.setCustomerId(rs.getInt("customer_id"));
            loan.setLoanSchemeId(rs.getInt("loan_scheme_id"));
           return loan;
        }
    }
    public class CustomerMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerAddress(rs.getString("customer_address"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerStatus(rs.getString("customer_status"));
            customer.setCustomerContact(rs.getInt("customer_contact"));
            customer.setUserName(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            return customer;
        }
    }
}
