package bank.project.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerStatus;
    private long customerContact;
    private String userName;
    private String password;
}