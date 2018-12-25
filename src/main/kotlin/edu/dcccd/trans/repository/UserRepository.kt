package edu.dcccd.trans.repository

import edu.dcccd.trans.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
}