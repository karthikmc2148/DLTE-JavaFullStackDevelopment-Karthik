package dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.remote;


import dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication,Integer> {
    @Modifying
    @Transactional
    @Query("update LoanApplication set statusOfApproval='approved' where cibil>700 and profession in('salaried', 'self-employed') and incomePerAnnum>3*:amount")
    public void loanApproval();
    @Modifying
    @Transactional
    @Query("update LoanApplication set statusOfApproval='not-approved' where cibil<700 or profession not in('salaried', 'self-employed') or incomePerAnnum<=3*:amount")
    public void loanNotApproval();

    public List<LoanApplication> findAllByStatusOfApproval(String status);

    public LoanApplication save(LoanApplication loanApplication);

}


