package edu.dcccd.trans.utils

import org.springframework.security.core.userdetails.User
import java.util.*

object WebUtils {

    fun toString(user: User): String {
        return "UserName: " + Arrays.toString(user.authorities.toTypedArray())
    }
}