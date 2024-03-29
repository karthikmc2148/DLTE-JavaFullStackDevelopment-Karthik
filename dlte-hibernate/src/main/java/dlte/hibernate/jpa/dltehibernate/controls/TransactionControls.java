package dlte.hibernate.jpa.dltehibernate.controls;
import dlte.hibernate.jpa.dltehibernate.model.Transaction;
import dlte.hibernate.jpa.dltehibernate.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//@RestController
public class TransactionControls {
  @Autowired
    private TransactionService transactionService;
  @PostMapping("/addTransaction")
    public Transaction saveMethodCalling(@RequestBody Transaction transaction){
      return transactionService.implementationOfSave(transaction);
  }
  @PostMapping("/findAll")
  public List<Transaction> findAllMethodCalling(){
    return transactionService.implementationOfFindAll();
  }
  @GetMapping("/findById/{transactionId}")
  public Optional<Transaction> findByIdMethodCalling(@PathVariable("transactionId") int transactionId){
    return transactionService.implementationOfFindById(transactionId);
  }
  @DeleteMapping("/del/{transactionId}")
  public String deleteByIdMethodCalling(@PathVariable("transactionId") int transactionId){
    return transactionService.implementOfDeleteById(transactionId);
  }
  @PutMapping("/update")
  public Transaction updateMethodImplementation(@RequestBody Transaction transactions){
    return transactionService.implementationOfSave(transactions);
  }
}
