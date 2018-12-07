package edu.dcccd.trans;

import edu.dcccd.trans.entity.Transaction;
import edu.dcccd.trans.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TransApplicationTests {
    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    TransactionRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDBcount() {
        long revs = repository.count();
        assertEquals(4L, revs);
    }

    @Test
    public void testDBall() {
        Iterable<Transaction> it = repository.findAll();
        it.forEach(t -> log.info("\n" + t.toString()));
    }
}

