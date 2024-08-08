# 강의 내용 메모

- 로그인 시도 시 DaoAuthenticationProvider 를 거쳐 
- UserDetailsManager 에서 loadUserByUsername 메서드 호출
- UserDetails 인터페이스
  - getAuthorities : 엔드 유저의 권한 또는 역할 목록을 보유
  - getPassword, getUsername : 엔드 유저의 비밀번호와 이름을 반환
  - isAccountNonExpired : 계정이 만료되지 않았는지
  - isAccountNonLocked :  잠기지 않았는지
  - isCredentialsNonExpired : 자격 증명이 만료되지 않았는지
  - isEnabled : 활성화되었는지 확인
- UserDetailsService 인터페이스
  - loadUserByUsername : 사용자 이름을 기반으로 사용자 정보를 가져오는 메서드
  - JdbcUserDetailsManager 에서는 미리 쿼리를 생성해두었다. (JdbcDaoImpl 참고)
    - ddl 파일은 users.ddl 에 있음
    - group manager 도 존재함
- UserDetailsManager 는 유저를 생성, 수정하는 등 전반적 관리 (UserDetailsService 를 상속받음)

- 기본적인 authenticate check 후 additionalAuthenticationChecks 메서드에서 비밀번호 검증

- Encoding 은 형식을 변환하는 것 (비밀이나 기밀성이 없음)
  - UNICODE 와 BASE64가 대표적이다
- Encryption 암호화나 기밀성을 보장하는 방식으로 데이터를 암호화
  - 개발자가 비밀키를 이용해 쉽게 복호화할 수 있다
- Hashing 은 데이터를 해시값으로 변환한다. 비가역적이다. 즉 일반 패스워드로 되돌릴 수 없다.
  - 저장된 패스워드와 입력한 패스워드를 비교한다(헤싱되어 있는)
  - 해싱은 시도할때마다 다른 해시 문자열을 반환한다.
  - 하지만 내부적으로는 같은 해시값을 가지게 한다.

- PasswordEncoder 는 인터페이스이고, 6개의 구현체가 있다.
  - NoOpPasswordEncoder : 비밀번호를 암호화하지 않는다. (테스트용)
  - StandardPasswordEncoder : SHA-256 해싱 함수를 사용한다. (legacy)
  - Pbkdf2PasswordEncoder : PBKDF2 해싱 함수를 사용한다. (무차별 대입 공격에 취약)
  - BCryptPasswordEncoder : BCrypt 해싱 함수를 사용한다.
  - SCryptPasswordEncoder : SCrypt 해싱 함수를 사용한다.
  - Argon2PasswordEncoder : Argon2 해싱 함수를 사용한다.
