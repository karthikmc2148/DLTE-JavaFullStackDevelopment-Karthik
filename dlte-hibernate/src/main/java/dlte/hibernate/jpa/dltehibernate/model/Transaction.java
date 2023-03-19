package dlte.hibernate.jpa.dltehibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactionId;
   // @Column(nullable=false)
    private String sender;
   // @Column(nullable=false)
    private String receiver;
   // @Column(nullable=false)
    private float amount;
    //@Column(nullable=false)
    private String mode;
   // @Column(nullable=false)
    private Date day;
}
