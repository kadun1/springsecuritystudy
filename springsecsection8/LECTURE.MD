# 강의 내용 메모

- VirtualFilterChain 의 doFilter 메서드에서 필터의 개수만큼 반복한다.
- 각 Filter 의 doFilter 메서드를 실행하게 된다

Security filter chain: [
    DisableEncodeUrlFilter
    ForceEagerSessionCreationFilter
    ForceEagerSessionCreationFilter
    WebAsyncManagerIntegrationFilter
    SecurityContextPersistenceFilter
    HeaderWriterFilter
    CorsFilter
    CsrfFilter
    LogoutFilter
    UsernamePasswordAuthenticationFilter
    DefaultLoginPageGeneratingFilter
    DefaultLogoutPageGeneratingFilter
    BasicAuthenticationFilter
    CsrfCookieFilter
    RequestCacheAwareFilter
    SecurityContextHolderAwareRequestFilter
    AnonymousAuthenticationFilter
    SessionManagementFilter
    ExceptionTranslationFilter
    AuthorizationFilter
]
- 대부분의 프로젝트에서는 filter는 before 나 after 를 사용 한다. (at은 잘 사용하지 않음)
- filter가 반드시 한번만 요청되어야 한다면 OncePerRequestFilter를 상속받아서 구현한다. (권장)
