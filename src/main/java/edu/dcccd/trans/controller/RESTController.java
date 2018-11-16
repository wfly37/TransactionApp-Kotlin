package edu.dcccd.trans.controller;

import edu.dcccd.trans.service.JokeService;
import edu.dcccd.trans.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    private final JokeService jokeService;
    private final TransactionService transactionService;

    @Autowired
    public RESTController( JokeService jokeService, TransactionService transactionService ) {
        this.jokeService = jokeService;
        this.transactionService = transactionService;
    }

    @GetMapping(value = ("/joke"))
    public String getJoke() throws Exception {
        return jokeService.getJoke("Craig", "Walls");
    }
/*
    @GetMapping(value = ("/download"))
    public ResponseEntity<List<Transaction>> getTrans( Model model) {
        List<Transaction> transactions = new ArrayList<>();
        transactionService.getAllTransaction().forEach(transactions :: add);
        if(!transactions.isEmpty())
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/
}
