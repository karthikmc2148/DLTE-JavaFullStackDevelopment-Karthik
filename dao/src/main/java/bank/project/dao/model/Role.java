package bank.project.dao.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Role POJO
public class Role {
    private int roleId;
    private String roleName;
    private String roleDescription;
    private String roleStatus;
    private int branchId;
    private String username;
    private String password;
    private int failedAttempts;


}
