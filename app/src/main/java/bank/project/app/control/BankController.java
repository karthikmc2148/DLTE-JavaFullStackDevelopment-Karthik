package bank.project.app.control;


import bank.project.dao.model.Customer;
import bank.project.dao.model.Loan;
import bank.project.dao.model.LoanScheme;
import bank.project.dao.model.Role;
import bank.project.dao.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
   //calls a method to provide the list of Loan Objects
    @GetMapping("/allLoans")
    public List<Loan> callingGetAllLoans() {
        logger.info(bundle.getString("AllLoans"));
        return bankService.getAllLoans();
    }
    //calls a method to provide the list of customer Objects
    @GetMapping("/allCustomers")
    public List<Customer> callingAllCustomers() {
        logger.info(bundle.getString("AllCustomers"));
        return bankService.getAllCustomers();
    }

    //calls a method to provide a customer object based on userName
    @GetMapping("/getCustomerByUserName/{userName}")
    public Customer callingGetCustomerByUserName(@PathVariable("userName") String userName){
        return bankService.getCustomerByUserName(userName);
    }

    //calls a method to provide a customer object based on customerId
    @GetMapping("/getCustomerById/{customerId}")
    public Customer callingGetCustomerById(@PathVariable("customerId") int customerId){
        return bankService.getCustomerById(customerId);
    }

    //calls a method to authenticate the admin or bank official
    @PostMapping("/authenticateAdminOrBanker")
    public String callingAuthenticateAdminOrBanker(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return bankService.authenticateAdminOrBanker(userName, password);
    }

    //calls a method to authenticate the customer
    @PostMapping("/authenticateCustomer")
    public String callingAuthenticateCustomer(@RequestParam("userName") String userName,@RequestParam("password") String password){
        logger.info("Entered authentication");
        return bankService.authenticateCustomer(userName,password);
    }

    //calls a method to provide the Role object based on userName
    @GetMapping("/getRole/{userName}")
    public Role callingGetRoleByUserName(@PathVariable("userName") String userName) {
        return bankService.getRoleByUserName(userName);
    }

    //calls a method to update the failed attempts
    @GetMapping("/failedAttemptsToAdminOrBanker/{userName}")
    public void callingFailedAttempts(@PathVariable("userName") String userName) {
        bankService.incrementFailedAttemptsToAdminOrBanker(userName);
    }

    //calls a method to set the default attempts
    @PutMapping("/setDefaultAttemptsToAdminOrBanker/{userName}")
    public void callingSetDefaultAttempts(@PathVariable("userName") String userName){
        bankService.setDefaultAttemptsToAdminOrBanker(userName);
    }

    //calls a method to provide the List of LoanScheme Objects
    @GetMapping("/allLoanScheme")
    public List<LoanScheme> callingGetLoanScheme(){

        return bankService.getAllLoanScheme();
    }
}