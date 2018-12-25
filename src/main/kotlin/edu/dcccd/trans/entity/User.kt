package edu.dcccd.trans.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
                val username: String,
                @Column(name = "Encrypted_Password") val encryptedPassword: String
) {
    constructor() : this(null, "", "")
}
