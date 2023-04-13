package bank.project.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private int loanSchemeId;
    private int loanAppId;
    private double loanAmount;
    private double loanEmi;
    private int customerId;
}