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
