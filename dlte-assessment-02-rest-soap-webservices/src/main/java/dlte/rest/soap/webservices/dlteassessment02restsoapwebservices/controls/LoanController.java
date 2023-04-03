package dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.controls;


import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.model.LoanApplication;
import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/insert")
    LoanApplication callingSaveMethod(@RequestBody LoanApplication loanApplication){
        return loanService.implementationOfSave(loanApplication);
    }

}
