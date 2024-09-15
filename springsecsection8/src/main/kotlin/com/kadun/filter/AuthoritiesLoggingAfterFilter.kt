package com.kadun.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder

class AuthoritiesLoggingAfterFilter: Filter {

    private val logger = LoggerFactory.getLogger(this::class.java.name)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val authentication = SecurityContextHolder.getContext().authentication
        if (null != authentication) {
            logger.info("User ${authentication.name} is successfully authenticated and has the authorities ${authentication.authorities}")
        }

        chain?.doFilter(request, response)
    }
}
