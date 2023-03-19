package dlite.hibernate.dltehibernatejparepository.remote;

import dlite.hibernate.dltehibernatejparepository.model.Transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

}
