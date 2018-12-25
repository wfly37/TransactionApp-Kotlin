package edu.dcccd.trans.service

import edu.dcccd.trans.repository.RoleRepository
import edu.dcccd.trans.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    private val userRepository: UserRepository? = null
    @Autowired
    private val roleRepository: RoleRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userName: String): UserDetails {
        val (id, username, encryptedPassword) = userRepository!!.findByUsername(userName)
                ?: throw UsernameNotFoundException("User $userName was not found in the database")

// [ROLE_USER, ROLE_ADMIN,..]
        val roleNames = roleRepository!!.findByUserId(id)

        val grantList = ArrayList<GrantedAuthority>()
        if (roleNames != null) {
            for (role in roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                val authority = SimpleGrantedAuthority(role.role)
                grantList.add(authority)
            }
        }

        return org.springframework.security.core.userdetails.User(username,
                encryptedPassword, grantList)
    }
}


