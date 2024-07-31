package com.kadun.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

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

    /*@Bean
    fun userDetailService(): InMemoryUserDetailsManager {

        *//**
         * Approach 1 where we use withDefaultPasswordEncoder() method
         * while creating the user details
         *//*
        *//*
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
        *//*

        *//**
         * Approach 2 where we use NoOpPasswordEncoder Bean
         *//*
        val admin: UserDetails = User.withUsername("admin")
            .password("12345")
            .authorities("admin")
            .build()
        val user: UserDetails = User.withUsername("user")
            .password("12345")
            .authorities("read")
            .build()
        return InMemoryUserDetailsManager(admin, user)
    }*/

//    @Bean
//    fun userDetailsService(datasource: DataSource) : UserDetailsService {
//        return JdbcUserDetailsManager(datasource)
//    }

    /**
     * NoOpPasswordEncoder is not recommended for production usage
     * Use only for non-prod
     *
     * @return PasswordEncoder
     */
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
