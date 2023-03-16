package dlte.hibernate.jpa.dltehibernate.services;

import dlte.hibernate.jpa.dltehibernate.model.Transactions;
import dlte.hibernate.jpa.dltehibernate.remote.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transactions implementationOfSave(Transactions transactions) {
        return transactionRepository.save(transactions);
    }

    public List<Transactions> implementationOfFindAll() {
        return (List<Transactions>) transactionRepository.findAll();
    }

    public Optional<Transactions> implementationOfFindById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public String implementOfDeleteById(long transactionId) {
        Transactions transactions = transactionRepository.findById(transactionId).get();
        String information = transactions.getTransactionId() + " has been Deleted";
        transactionRepository.deleteById(transactionId);
        return information;
    }

}