package dlte.hibernate.jpa.dltehibernate.remote;

import dlte.hibernate.jpa.dltehibernate.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions,Long> {
}
