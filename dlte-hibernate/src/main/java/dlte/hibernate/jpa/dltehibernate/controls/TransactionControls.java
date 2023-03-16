package dlte.hibernate.jpa.dltehibernate.controls;
import dlte.hibernate.jpa.dltehibernate.model.Transactions;
import dlte.hibernate.jpa.dltehibernate.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;

@RestController
public class TransactionControls {
  @Autowired
    private TransactionService transactionService;
  @PostMapping("/addTransactions")
    public Transactions saveMethodCalling(@RequestBody Transactions transactions){
      return transactionService.implementationOfSave(transactions);
  }
  @PostMapping("/findAll")
  public List<Transactions> findAllMethodCalling(){
    return transactionService.implementationOfFindAll();
  }
  @GetMapping("/findById/{transactionId}")
  public Optional<Transactions> findByIdMethodCalling(@PathVariable("transactionId") long transactionId){
    return transactionService.implementationOfFindById(transactionId);
  }
  @DeleteMapping("/del/{transactionId}")
  public String deleteByIdMethodCalling(@PathVariable("transactoinId") long transactionId){
    return transactionService.implementOfDeleteById(transactionId);
  }
  @PutMapping("/update")
  public Transactions updateMethodImplementation(@RequestBody Transactions transactions){
    return transactionService.implementationOfSave(transactions);
  }
}
