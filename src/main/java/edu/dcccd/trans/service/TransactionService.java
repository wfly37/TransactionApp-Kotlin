package edu.dcccd.trans.service;

import edu.dcccd.trans.entity.Transaction;

import java.util.List;

public interface TransactionService
{
    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
}

