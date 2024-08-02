package com.kadun.config

import com.kadun.model.Customer
import com.kadun.repository.CustomerRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class EasyBankUserDetails(
    private val customerRepository: CustomerRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        var userName: String?
        var password: String?
        val authorities = mutableListOf<GrantedAuthority>()
        val customer: List<Customer> = customerRepository.findByEmail(username!!)
        if (customer.isEmpty()) {
            throw UsernameNotFoundException("User details not found for the user : $username")
        } else {
            userName = customer[0].email
            password = customer[0].pwd
            authorities.add(SimpleGrantedAuthority(customer[0].role))
        }
        return User(userName, password, authorities)
    }
}
