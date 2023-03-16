package dlte.hibernate.jpa.dltehibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transactions {
    @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long transactionId;
    @NonNull
    private String sender;
    @NonNull
    private String receiver;
     @NonNull
    private double amount;
     @NonNull
    private String type;
}
