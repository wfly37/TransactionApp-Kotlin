package edu.dcccd.trans

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransApplication

fun main(args: Array<String>) {
    runApplication<TransApplication>(*args)
}

