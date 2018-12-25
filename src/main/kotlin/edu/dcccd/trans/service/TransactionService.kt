package edu.dcccd.trans.service

import edu.dcccd.trans.entity.Transaction

interface TransactionService {
    val allTransaction: Iterable<Transaction>
    fun createTransaction(transaction: Transaction): String
}

