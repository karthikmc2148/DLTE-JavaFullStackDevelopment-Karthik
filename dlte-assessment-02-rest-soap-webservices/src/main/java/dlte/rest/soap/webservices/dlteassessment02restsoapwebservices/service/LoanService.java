package dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.service;

import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.model.LoanApplication;
import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.remote.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
  @Autowired
    private LoanRepository loanRepository;

  public LoanApplication implementationOfSave(LoanApplication loanApplication){
      return loanRepository.save(loanApplication);
  }
  public String implementationOfLoanApproval(){
       loanRepository.loanApproval();
      return "Updated the Loan Approval Status";
  }
    public String implementationOfLoanNotApproval(){
        loanRepository.loanNotApproval();
        return "Updated the Loan not Approval Status";
  }
  public List<LoanApplication> implementationOfStatusOfNotApproval(){
      return loanRepository.findAllByStatusOfNotApproval();
  }
}
