package edu.dcccd.trans.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "TRANSACTION")
data class Transaction(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
                       var time: String? = null,
                       val day: String? = null,
                       val description: String = "",
                       @Column(precision = 7, scale = 2) val amount: BigDecimal = BigDecimal.ZERO,
                       val type: String = ""
    )
//    constructor() { this.time = currentTime() }
//{
//    private fun currentTime(): String = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
//}
