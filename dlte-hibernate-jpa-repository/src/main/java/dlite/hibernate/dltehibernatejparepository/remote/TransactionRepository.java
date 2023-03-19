package dlite.hibernate.dltehibernatejparepository.remote;

import dlite.hibernate.dltehibernatejparepository.model.Transaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
    //  fetch List of Transaction by given sender
   List<Transaction> findAllBySender(String sender);
    //  fetch the List of Transaction by greater than given amount
   @Query("from Transaction where amount>= : balance")
    List<Transaction> findAllByAmount(float balance);
   // fetch the List of amounts matches the given type(Credit/debit)
    @Query("select amount from Transaction where type = : kind")
    List<Float> findAllByType(String kind);
}
