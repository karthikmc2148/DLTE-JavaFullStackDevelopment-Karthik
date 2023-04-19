package bank.project.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
//customer POJO
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerStatus;
    private long customerContact;
    private String userName;
    private String password;
    private int failedAttempts;
}