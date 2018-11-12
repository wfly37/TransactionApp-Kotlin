package edu.dcccd.trans.service;

import edu.dcccd.trans.entity.Transaction;
import edu.dcccd.trans.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService
{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public String createTransaction(Transaction transaction) {
        boolean mybool = false;
        try {
            transactionRepository.save(transaction);
        }catch(Exception e){
            mybool = true;
        }
        return mybool?"Failed.":"Successful.";
    }

    @Override
    public Iterable<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
}
