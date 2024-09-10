package com.kadun.config

import com.kadun.model.Authority
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
                return UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer[0].authorities))
            } else {
                throw BadCredentialsException("Invalid password")
            }
        } else {
            throw BadCredentialsException("No user registered with this email")
        }
    }

    private fun getGrantedAuthorities(authorities: Set<Authority>): List<GrantedAuthority> {
        val grantedAuthorities = mutableListOf<GrantedAuthority>()
        authorities.forEach {
            grantedAuthorities.add(SimpleGrantedAuthority(it.name))
        }
        return grantedAuthorities
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}
