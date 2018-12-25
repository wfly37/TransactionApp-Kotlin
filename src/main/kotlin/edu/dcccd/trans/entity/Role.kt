package edu.dcccd.trans.entity

import javax.persistence.*

@Entity
@Table(name = "roles")
data class Role(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
                val role: String,
                @Column(name = "user_id") val userId: Long?
) {
    constructor() : this(null, "", null)
}