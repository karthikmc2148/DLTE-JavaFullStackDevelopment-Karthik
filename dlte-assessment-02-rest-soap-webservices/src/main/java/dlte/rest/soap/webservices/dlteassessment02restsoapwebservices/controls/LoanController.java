package dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.controls;


import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.model.LoanApplication;
import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/insert")
     public LoanApplication callingSaveMethod(@RequestBody LoanApplication loanApplication){
        return loanService.implementationOfSave(loanApplication);
    }
    @GetMapping("/setApproval")
    public String callingLoanApprovalMethod(){
        return loanService.implementationOfLoanApproval();
    }
    @GetMapping("/setNotApproval")
    public String callingLoanNotApprovalMethod(){
        return loanService.implementationOfLoanNotApproval();
    }
    @GetMapping("/listNotApproval")
    public List<LoanApplication> callingListOfNotApproval(){
        return loanService.implementationOfStatusOfNotApproval();
    }
}
