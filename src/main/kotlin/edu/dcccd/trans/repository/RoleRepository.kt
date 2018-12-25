package edu.dcccd.trans.repository

import edu.dcccd.trans.entity.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : CrudRepository<Role, Long> {
    fun findByUserId(@Param("user_id") user_id: Long?): List<Role>
}