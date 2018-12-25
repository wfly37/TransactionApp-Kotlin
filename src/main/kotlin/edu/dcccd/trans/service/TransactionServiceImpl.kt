package edu.dcccd.trans.service

import edu.dcccd.trans.entity.Transaction
import edu.dcccd.trans.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TransactionServiceImpl : TransactionService {

    @Autowired
    internal var transactionRepository: TransactionRepository? = null

    override val allTransaction: Iterable<Transaction>
        get() = transactionRepository!!.findAll()

    override fun createTransaction(transaction: Transaction): String {
        var mybool = false
        try {
            transactionRepository!!.save(transaction)
        } catch (e: Exception) {
            mybool = true
        }

        return if (mybool) "Failed." else "Successful."
    }
}
