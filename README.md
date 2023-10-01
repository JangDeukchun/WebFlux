# 코틀린으로 구현하는 Spring WebFlux

## 환경
- macOS M1
- Kotlin 1.8.21 on Java 17
- IDE: IntelliJ
- Spring Boot 3.1.0 WebFlux
- RDBMS: MySQL v8.0.33
- Build: Gradle v8.1.1

## 소개
Spring WebFlux는 클라이언트 및 서버 양쪽에서 반응형 스타일의 애플리케이션을 개발하는 데 도움이 되는 스프링 프레임워크의 모듈입니다. 전통적인 Spring WebMVC가 Servlet API를 기반으로 구축된 웹 프레임워크인 반면, WebFlux는 리액티브 원칙을 중심으로 한 웹 프레임워크를 제공합니다.

## Spring WebMVC vs WebFlux

### Spring WebMVC
- 기본적으로 블로킹 및 동기식.
- 각 사용자 요청을 처리하기 위해 스레드를 사용하며, 이는 자원 비효율성으로 이어질 수 있음.
- 동시 요청이 스레드 풀 크기를 초과하는 경우 "Thread Pool Hell" 발생 가능.

### WebFlux
- 이벤트 기반 및 논블로킹.
- 비동기로 요청을 처리하며, 자원을 효율적으로 사용할 수 있음.
- 대량의 동시 요청을 효과적으로 처리할 수 있는 장점.

## WebFlux 사용 이유
- 비동기 및 논블로킹: 자원 소모를 최소화하면서 동시 요청을 효율적으로 처리할 수 있음.
- 리액티브 프로그래밍: Reactor 라이브러리와 Netty를 기반으로 한 이벤트 기반 및 논블로킹 서버.

## WebFlux 함수형 스타일의 장점
- 명시적인 코드로 모든 웹 요청 처리 작업을 작성.
- 어노테이션 기반의 Spring MVC에 비해 명확한 타입 체크와 명시적인 코드.
- 편리한 구성 및 추상화를 위해 함수 조합이 용이.
- 명확한 구조로 테스트 작성이 편리함.

## Netty vs. Node.js
### Netty 개념
- **채널:** 네트워크 연결을 나타내며, JavaScript의 Socket 객체와 유사.
- **이벤트 루프:** 비동기 이벤트 처리를 지원하기 위해 사용되며, Node.js의 이벤트 루프와 유사.
- **핸들러:** 읽기 및 쓰기 작업을 처리하는 데 사용되며, JavaScript의 데이터 이벤트 핸들러 또는 콜백 함수와 유사.
- **파이프라인:** 데이터 처리 작업의 연속된 체인을 나타내며, JavaScript의 함수 또는 프라미스 체인과 유사.
- **부트스트랩:** 네트워크 애플리케이션을 초기화하고 시작하는 데 사용되며, JavaScript에서 서버를 부트스트랩하는 것과 유사.

### Node.js 비교
- Node.js는 Netty와 유사한 이벤트 기반 및 논블로킹 이벤트 루프를 사용하는 JavaScript 런타임.
- Node.js에서 데이터 처리 작업은 콜백 함수를 사용하여 처리됨.
- Node.js 생태계에서 웹 서버를 부트스트랩하기 위해 주로 Express.js를 사용.

## 시작하기
Kotlin 및 코루틴을 사용하여 Spring WebFlux 프로젝트를 설정하고 실행하는 방법에 대한 단계별 가이드입니다.

최종적으로 이 프로젝트에서 사용하는 것은 build.gradle.kts를 통해서 확인하면 됩니다.

### Chapter 1: 01-using-controller-user
-  [Chapter 1 브랜치로 이동](https://github.com/GiWoonHwang/WebFlux/tree/01-using-controller-user)


### Chapter 2: 02-using-controller-mugi
- [Chapter 2 브랜치로 이동](https://github.com/GiWoonHwang/WebFlux/tree/02-using-controller-mugi)

### Chapter 3: 03-using-functinal-endpoints
- [Chapter 3 브랜치로 이동](https://github.com/GiWoonHwang/WebFlux/tree/03-using-functinal-endpoints)

