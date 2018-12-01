package edu.dcccd.trans.controller;

import edu.dcccd.trans.entity.Transaction;
import edu.dcccd.trans.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TransactionController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping(value = {"/", "/home"})
    public String homePage(Model model){
        model.addAttribute("appName",appName);
        return "home";
    }

    @GetMapping("/transaction")
    public String loadTransactionPage(Model model){
        model.addAttribute("transactionForm", new Transaction());
        model.addAttribute("days",getDays());
        model.addAttribute("transactions", transactionService.getAllTransaction());
        return "transaction";
    }

    @PostMapping(value="/create")
    public String createTransaction( @Valid
                                     @ModelAttribute("transactionForm")
                                     Transaction transaction,
                                     BindingResult bindingResult,
                                     Model model ){
        // if catch any error
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                .getFieldErrors().stream()
                .map(s -> s.getField().concat("'s field is empty!"))
                .collect(Collectors.toList());
            model.addAttribute("days",getDays());
            model.addAttribute("transactions", transactionService.getAllTransaction());
            model.addAttribute("errors", errors);
            return "transaction";
        }
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        transaction.setTime(time);
        transactionService.createTransaction(transaction);
        return "redirect:transaction";
    }

    private List<String> getDays(){
        return Arrays.stream(DayOfWeek.values())
            .map(Enum :: toString)
            .collect(Collectors.toList());
    }
}

