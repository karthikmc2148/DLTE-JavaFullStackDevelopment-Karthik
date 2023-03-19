package dlite.hibernate.dltehibernatejparepository.services;

import dlite.hibernate.dltehibernatejparepository.model.Transaction;
import dlite.hibernate.dltehibernatejparepository.remote.TransactionRepository;
import dlite.hibernate.dltehibernatejparepository.model.Transaction;
import dlite.hibernate.dltehibernatejparepository.remote.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction implementationOfSave(Transaction transactions) {
        return transactionRepository.save(transactions);
    }

    public List<Transaction> implementationOfFindAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public Optional<Transaction> implementationOfFindById(int transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public String implementOfDeleteById(int transactionId) {
        Transaction transactions = transactionRepository.findById(transactionId).get();
        String information = transactions.getTransactionId() + " has been Deleted";
        transactionRepository.deleteById(transactionId);
        return information;
    }

}