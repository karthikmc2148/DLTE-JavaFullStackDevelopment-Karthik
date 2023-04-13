package bank.project.app.control;


import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.Role;
import bank.project.dao.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/bank")
 public class BankController {
    @Autowired
    private BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);
    ResourceBundle bundle = ResourceBundle.getBundle("bank");

    @GetMapping("/allLoans")
    public List<Loan> callingGetAllLoans() {
        logger.info(bundle.getString("AllLoans"));
        return bankService.getAllLoans();
    }

    @GetMapping("/allCustomers")
    public List<Customer> callingAllCustomers() {
        logger.info(bundle.getString("AllCustomers"));
        return bankService.getAllCustomers();
    }
    @GetMapping("/getCustomerByName/{customerName}")
    public Customer callingGetCustomerByCustomerName(@PathVariable("customerName") String customerName){
        return bankService.getCustomerByName(customerName);
    }
    @GetMapping("/getCustomerById/{customerId}")
    public Customer callingGetCustomerById(@PathVariable("customerId") int customerId){
        return bankService.getCustomerById(customerId);
    }
    @PostMapping("/authenticate")
    public String callingAuthenticate(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return bankService.authenticate(userName, password);
    }

    @GetMapping("/getRole/{userName}")
    public Role callingGetRoleByUserName(@PathVariable("userName") String userName) {
        return bankService.getRoleByUserName(userName);
    }

    @GetMapping("/getCustomer/{customerId}")
    public Loan callingGetLoanByCustomerId(@PathVariable("customerId") int customerId) {
        return bankService.getLoanByCustomerId(customerId);
    }

    @GetMapping("/failedAttempts/{userName}")
    public void callingFailedAttempts(@PathVariable("userName") String userName) {
        bankService.incrementfailedAttempts(userName);
    }

    @GetMapping("/setDefaultAttempts/{userName}")
    public void callingSetDefaultAttempts(@PathVariable("userName") String userName){
        bankService.setDefaultAttempts(userName);


    }
}