package edu.dcccd.trans.service;

import edu.dcccd.trans.entity.Transaction;

public interface TransactionService
{
    String createTransaction(Transaction transaction);
    Iterable<Transaction> getAllTransaction();
}

