package dlite.hibernate.dltehibernatejparepository.controls;


import dlite.hibernate.dltehibernatejparepository.model.Transaction;
import dlite.hibernate.dltehibernatejparepository.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionControls {
  @Autowired
    private TransactionService transactionService;
  @PostMapping("/addTransaction")
    public Transaction saveMethodCalling(@RequestBody Transaction transaction){
      return transactionService.implementationOfSave(transaction);
  }
  @GetMapping("/findAll")
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
  public Transaction updateMethodImplementation(@RequestBody Transaction transaction){
    return transactionService.implementationOfSave(transaction);
  }
  @GetMapping("/listSenderTransactions/{sender}")
  public List<Transaction> findAllBySenderCalling(@PathVariable("sender") String sender){
    return transactionService.implementationOfFindAllBySender(sender);
  }
  @GetMapping("/greaterThanAmount/{amount}")
  public List<Transaction> findAllByAmountCalling(@PathVariable("amount") float amount){
    return transactionService.implementationOfFindAllByAmount(amount);
  }
  @GetMapping("/listOfAmounts/{type}")
  public List<Float> findAllByTypeCalling(@PathVariable("type") String type){
    return transactionService.implementationOfFindAllByType(type);
  }
}
