# 강의 내용 메모

- CsrfTokenRequestAttributeHandler 클래스로 토큰 생성
- CookieCsrfTokenRepository 클래스로 토큰 저장
- BasicAuthenticationFilter 클래스에서 convert() 메서드로 request 를 UsernamePasswordAuthenticationToken 으로 변환

- 권한 관련 (Authorization)
    - Authority, Role 로 구분됨
    - GrantedAuthority 인터페이스가 있고, 이를 구현한 SimpleGrantedAuthority 클래스가 있음
    - authenticate() 에서 UsernamePasswordAuthenticationToken 객체를 생성할 때, 권한을 설정할 수 있음
