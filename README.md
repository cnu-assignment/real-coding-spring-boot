# [spring boot] weather crawler

- 어떤 구조를 가지고 있는가?

```
.
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml // maven : 사전에 정의된 컴포넌트와 그와 관련된 의존성 라이브러리들에 대한 정의
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.cnu.realcoding.weathercrawler
│   │   │       ├── WeatherCrawlerApplication.java // 실행될 때 세부적인 것 포함
│   │   │       ├── config // 설정을 해야한다면 여기에
│   │   │       │   └── SwaggerConfig.java
│   │   │       ├── controller // 클라이언트와 request / response(로직 전까지 준비물)
│   │   │       │   └── DogController.java
│   │   │       ├── domain // VO(DTO) 오브젝트 getter, setter 나누어줌 - 정보은닉
│   │   │       │   └── Dog.java
│   │   │       └── service // 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
│   │   │           └── DogService.java
│   │   └── resources // 웹 정적, 동적 리소스
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── org.cnu.realcoding.weathercrawler
│               └── WeatherCrawlerApplicationTests.java
├── target
│   ├── classes
│   │   ├── application.properties
│   │   └── org
│   │       └── cnu
│   │           └── realcoding
│   │               └── weathercrawler
│   │                   ├── WeatherCrawlerApplication.class
│   │                   ├── config
│   │                   │   └── SwaggerConfig.class
│   │                   ├── controller
│   │                   │   └── DogController.class
│   │                   ├── domain
│   │                   │   └── Dog.class
│   │                   └── service
│   │                       └── DogService.class
│   ├── generated-sources
│   │   └── annotations
│   ├── generated-test-sources
│   │   └── test-annotations
│   └── test-classes
│       └── org.cnu.realcoding.weathercrawler
│           └── WeatherCrawlerApplicationTests.class
└── weather-crawler.iml

39 directories, 19 files

```

- Spring package convention
  - controller : 우리 웹 서버에서 제공할 api들
  - service : 비즈니스 영역(구현객체) - 컨트롤러와 DAO(Data access Object) 사이의 접착
  - repository : DB쪽 호출하는 녀석들
  - api : 외부 api를 호출하는 녀석들
  - config : 설정 클래스들, 특히 Bean 제공하는 메소드들
  - domain : value object 등
- DTO(Data Transfer Object)
  - = VO(Value Object) // 값을 위해 쓰는 것
    - DTO는 인스턴스 개념이고 VO는 리터럴 값(을 흉내낸)개념
  - 데이터를 오브젝트로 변환하는 객체
  - Layer간(쉽게 한가지 예를 들자면, 서버 코딩 -> view 코딩)에 데이터를 넘길때는 DTO를 쓰면 편함
  -  데이터가 자동적으로 클래스화가 된다는 것
  
- Lombok 의 @DaTa를 적용하여 도메인 클래스에 getter/setter 생략 가능

- Annotation
  - @SpringBootApplication 
    - @Configuration + @EnableAutoConfiguration + @ComponenetScan
        - @Configuration : 현재 클래스가 스프링 설정파일임을 Spring Context에게 알려줌
        - @EnableAutoConfiguration : 스프링 부트 클래스 path 세팅에 대한 다양한 bean 추가
        - @ComponenetScan : 다른 컴포넌트, 서비스, 설정 등을 찾을 수 있게 도와줌
- 과제를 다시 진행하면 어려웠던 것

## [웹 기본개념](https://jinbroing.tistory.com/86?category=697142)
- 
- [RESTful](https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense)
- [아파치와 톰캣의 차이](https://limmmee.tistory.com/4)
- [자바 유틸들](https://start.goodtime.co.kr/2014/06/%EC%95%8C%EC%95%84%EB%91%90%EB%A9%B4-%ED%8E%B8%EB%A6%AC%ED%95%9C-%EC%9E%90%EB%B0%94-%EC%9C%A0%ED%8B%B8%EB%A6%AC%ED%8B%B0-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%93%A4/)