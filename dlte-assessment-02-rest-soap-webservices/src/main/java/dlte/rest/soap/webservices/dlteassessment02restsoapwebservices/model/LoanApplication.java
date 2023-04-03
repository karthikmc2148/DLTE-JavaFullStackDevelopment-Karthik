package dlte.rest.soap.webservices.dlteassessment02restsoapwebservices.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanApplication {
   @Id
   private int loanRequestNumber;
   private float requestedAmount;
   private  int cibil;
   private long aadhaar;
   private String pan;
   private String profession;
   private float incomePerAnnum;
   private String statusOfApproval;
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;
}
