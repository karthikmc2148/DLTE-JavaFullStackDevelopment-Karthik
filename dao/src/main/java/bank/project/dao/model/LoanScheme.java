package bank.project.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Loan_scheme POJO
public class LoanScheme {
    private int loanSchemeId;
    private String loanSchemeType;
    private String loanSchemeName;
    private String loanSchemeDescription;
    private float loanSchemeRoi;
}