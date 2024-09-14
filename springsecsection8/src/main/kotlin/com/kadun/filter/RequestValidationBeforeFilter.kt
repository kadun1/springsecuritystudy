package com.kadun.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.util.StringUtils
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.Base64

const val AUTHENTICATION_SCHEME_BASIC = "Basic"

class RequestValidationBeforeFilter: Filter {

    private val credentialsCharset: Charset = StandardCharsets.UTF_8

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        val req: HttpServletRequest = request as HttpServletRequest
        val res: HttpServletResponse = response as HttpServletResponse
        var header = req.getHeader(AUTHORIZATION)
        if (header != null) {
            header = header.trim()
            if (StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME_BASIC)) {
                val base64Token: ByteArray = header.substring(6).toByteArray(StandardCharsets.UTF_8)
                val decoded: ByteArray
                try {
                    decoded = Base64.getDecoder().decode(base64Token)
                    val token = String(decoded, credentialsCharset)
                    val delim = token.indexOf(":")
                    if (delim == -1) {
                        throw BadCredentialsException("Invalid basic authentication token")
                    }
                    val email = token.substring(0, delim)
                    if (email.lowercase().contains("test")) {
                        res.status = HttpServletResponse.SC_BAD_REQUEST
                        return
                    }
                } catch (e: IllegalArgumentException) {
                    throw BadCredentialsException("Failed to decode basic authentication token")
                }
            }
        }
        chain?.doFilter(request, response)
    }
}
