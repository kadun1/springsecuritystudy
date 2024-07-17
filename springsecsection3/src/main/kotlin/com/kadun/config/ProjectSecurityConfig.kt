package com.kadun.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ProjectSecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain? {

        http.authorizeHttpRequests {
            it.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll()
        }
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        return http.build()
    }

    @Bean
    fun userDetailService(): InMemoryUserDetailsManager {

        /**
         * Approach I where we use withDefaultPasswordEncoder() method
         * while creating the user details
         */

        val admin: UserDetails = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("12345")
            .authorities("admin")
            .build()
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("12345")
            .authorities("read")
            .build()

        return InMemoryUserDetailsManager(admin, user)
    }
}
