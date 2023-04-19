package bank.project.dao;

import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.LoanScheme;
import bank.project.dao.model.Role;
import bank.project.dao.service.BankService;
import lombok.val;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {
    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    BankService bankService;

    @Test
    public void testRoleDetails() {
        Role role1 = new Role(21, "admin", "view and edit all the feilds of bank", "active", 101, "karthik", "karthik123",2);
        Role role2 = new Role(22, "banker", "view all the feilds of bank", "active", 103, "razak", "razak123",1);
        Role role3 = new Role(25, "admin", "view and update all the feilds of bank", "inactive", 104, "apoorva", "apoorva123",1);
        List<Role> roleList = Stream.of(role1, role2, role3).collect(Collectors.toList());

        when(jdbcTemplate.query(eq("select * from loan"), any(RowMapper.class))).thenReturn(roleList);
        assertEquals(roleList.get(2), bankService.getAllLoans().get(2));
    }

    @Test
    public void testCustomerDetails(){
        Customer customer1 = new Customer(64, "karthik", "Siddartha Colony, Ballari-583101", "active", 345764325,"karthik", "karthik123",3);
        Customer customer2 = new Customer(62, "ganesh", "Dollers Colony, Banglore-583187", "inactive", 346573472,"ganesh", "ganesh123",3);
        Customer customer3 = new Customer(69, "madhuri", "Shivaji Colony, mysore-583101", "active", 87654275,"madhuri", "madhuri123",3);

        List<Customer> customerList = Stream.of(customer1, customer2, customer3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from customer"), any(RowMapper.class))).thenReturn(customerList);
        assertNotEquals(customer2, bankService.getAllCustomers().get(0));
    }
    @Test
    public void testLoanDetails(){
        Loan loan1 = new Loan(231,3241,66355.63,4854,100);
        Loan loan2 = new Loan(322,3211,755775.63,43453.34,104);
        Loan loan3 = new Loan(422,7451,98763455.63,98732.24,103);
        List<Loan> loanList = Stream.of(loan1,loan2, loan3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan"),any(RowMapper.class))).thenReturn(loanList);
        assertEquals(loanList,bankService.getAllLoans().subList(0,3));
    }
    @Test
    public void testLoanScheme(){
        LoanScheme loanScheme1 = new LoanScheme(54,"gold loan","siri", "24 carrot gold accepted",6.23f );
        LoanScheme loanScheme2 = new LoanScheme(45,"car loan","siri", "24 carrot gold accepted",6.23f );
        LoanScheme loanScheme3 = new LoanScheme(87,"home loan","siri", "24 carrot gold accepted",6.23f );
        List<LoanScheme> loanSchemeList = Stream.of(loanScheme1,loanScheme2,loanScheme3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"),any(RowMapper.class))).thenReturn(loanSchemeList);
        assertEquals(loanSchemeList,bankService.getAllLoanScheme().subList(0,3));
    }
    @Test
    public void testGetCustomerById(){
        int id=64;
        Customer customer1 = new Customer(64, "karthik", "Siddartha Colony, Ballari-583101", "active", 345764325,"karthik", "karthik123",3);
        when(jdbcTemplate.queryForObject(eq("select * from customer where customer_id=?"), eq(new Object[]{id}), any(RowMapper.class))).thenReturn(customer1);
        Customer customer2 = bankService.getCustomerById(64);
        assertEquals(customer1,customer2);
    }
    @Test
    public void testGetCustomerByUserName(){
        String name = "karthik";
        Customer customer1 = new Customer(64, "Karthik M C", "Siddartha Colony, Ballari-583101", "active", 345764325,"karthik", "karthik123",3);
        when(jdbcTemplate.queryForObject(eq("select * from customer where username=?"),eq(new Object[]{name}),any(RowMapper.class))).thenReturn(customer1);
        Customer customer2 = bankService.getCustomerByUserName(name);
        assertEquals(customer1,customer2);
    }
}