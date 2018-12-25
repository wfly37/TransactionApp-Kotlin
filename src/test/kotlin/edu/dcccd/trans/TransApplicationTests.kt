package edu.dcccd.trans

import edu.dcccd.trans.controller.TransactionController
import edu.dcccd.trans.repository.TransactionRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.logging.Logger

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransApplicationTests {
    internal var log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
    @Autowired
    internal var repository: TransactionRepository? = null
    @Autowired
    internal var tc : TransactionController? = null

    @Test
    fun contextLoads() {
    }

    @Test
    fun testDBcount() {
        val revs = repository!!.count()
        assertEquals(4L, revs)
    }

    @Test
    fun testDBall() {
        val it = repository!!.findAll()
        it.forEach { t -> log.info("\n" + t.toString()) }
    }

    @Test
    fun testGetDays() {
        println(tc?.getDays())
        assertEquals(listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
                tc?.getDays())
    }
}

