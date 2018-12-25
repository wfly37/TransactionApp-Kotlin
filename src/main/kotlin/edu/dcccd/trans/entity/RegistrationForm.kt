package edu.dcccd.trans.entity

import org.springframework.security.crypto.password.PasswordEncoder

data class RegistrationForm(var username: String? = null,
                            var password: String? = null,
                            var confirm: String? = null
)
{
    fun toUser(passwordEncoder: PasswordEncoder): User {
        return User(null, this.username!!, passwordEncoder.encode(this.password))
    }
}
