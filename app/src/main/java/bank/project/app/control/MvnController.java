package bank.project.app.control;

import bank.project.dao.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("mvn")
public class MvnController {
    BankService bankService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping("/homePage")
    public String homePage(){
        return "home-page";
    }
    @GetMapping("/approvals")
    public String approvals(){
        return "approvals";
    }
    @GetMapping("/customerSearch")
    public String customerSearch(){
        return "customer-Search";
    }
    @GetMapping("/loanSearch")
    public String loanSearch(){
        return "Loan-search";
    }
    @GetMapping("/createLoan")
    public String createLoan(){
        return "create-loan";
    }
}
