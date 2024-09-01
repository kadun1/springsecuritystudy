package com.kadun.config

import com.kadun.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class EasyBankUsernamePwdAuthenticationProvider: AuthenticationProvider {

    @Autowired
    private  lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    override fun authenticate(authentication: Authentication?): Authentication {
        val username = authentication?.name ?: ""
        val pwd = authentication?.credentials.toString()
        val customer = customerRepository.findByEmail(username)
        if (customer.isNotEmpty()) {
            if (passwordEncoder.matches(pwd, customer[0].pwd)) {
                val authorities = arrayListOf<GrantedAuthority>()
                authorities.add(SimpleGrantedAuthority(customer[0].role))
                return UsernamePasswordAuthenticationToken(username, pwd, authorities)
            } else {
                throw BadCredentialsException("Invalid password")
            }
        } else {
            throw BadCredentialsException("No user registered with this email")
        }

    }

    override fun supports(authentication: Class<*>?): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}
