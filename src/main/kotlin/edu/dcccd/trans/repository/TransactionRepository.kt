package edu.dcccd.trans.repository

import edu.dcccd.trans.entity.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : CrudRepository<Transaction, Long>
