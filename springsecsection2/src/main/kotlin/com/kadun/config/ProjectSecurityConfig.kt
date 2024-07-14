package com.kadun.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ProjectSecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        /**
         * below is the custom security configurations
         */
        http.authorizeHttpRequests {
            it.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll()
        }
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        return http.build()

        /**
         * Configuring the security to deny all requests
         */
        /*
        http.authorizeHttpRequests {
            it.anyRequest().denyAll()
        }
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        return http.build()
         */

        /**
         * Configuring the security to permit all requests
         */
        /*
        http.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        return http.build()
         */
    }


}
