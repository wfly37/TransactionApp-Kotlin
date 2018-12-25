package edu.dcccd.trans.controller

import edu.dcccd.trans.entity.Transaction
import edu.dcccd.trans.service.TransactionServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import javax.validation.Valid

@Controller
class TransactionController {

    @Value("\${spring.application.name}")
    private val appName: String? = null

    @Autowired
    private  var transactionService: TransactionServiceImpl? = null

    @GetMapping(value = ["/", "/home"])
    fun homePage(model: Model): String {
        model.addAttribute("appName", appName)
        return "home"
    }

    @GetMapping(value = ["/transaction"])
    fun loadTransactionPage(model: Model): String {
        model.addAttribute("transactionForm", Transaction())
        model.addAttribute("days", getDays())
        model.addAttribute("transactions", transactionService!!.allTransaction)
        return "transaction"
    }

    @PostMapping(value = ["/create"])
    fun createTransaction(@Valid
                          @ModelAttribute("transactionForm")
                          transaction: Transaction,
                          bindingResult: BindingResult,
                          model: Model): String {
        // if catch any error
        if (bindingResult.hasErrors()) {
            val errors = bindingResult
                    .fieldErrors.stream()
                    .map { s -> s.field + "'s field is empty!" }
                    .map {it}
            model.addAttribute("days", getDays())
            model.addAttribute("transactions", transactionService!!.allTransaction)
            model.addAttribute("errors", errors)
            return "transaction"
        }
        val now = LocalDateTime.now()
        val time = now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
        transaction.time = time
        transactionService!!.createTransaction(transaction)
        return "redirect:transaction"
    }

    fun getDays(): List<String> {
        // Get DayOfWeek enums value
        val dow = mutableListOf<String>()
        for (c in DayOfWeek.values()) dow += c.toString()
        return dow
    }
}


