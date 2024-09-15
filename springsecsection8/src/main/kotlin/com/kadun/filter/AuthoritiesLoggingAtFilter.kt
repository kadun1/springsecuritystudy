package com.kadun.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.slf4j.LoggerFactory

class AuthoritiesLoggingAtFilter: Filter {

    private val logger = LoggerFactory.getLogger(this::class.java.name)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        logger.info("Authentication Validation is in progress")
        chain?.doFilter(request, response)
    }
}
