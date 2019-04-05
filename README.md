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
│   │   │       ├── WeatherCrawlerApplication.java
│   │   │       ├── config // 설정을 해야한다면 여기에
│   │   │       │   └── SwaggerConfig.java
│   │   │       ├── controller // 클라이언트와 request / response(로직 전까지 준비물)
│   │   │       │   └── DogController.java
│   │   │       ├── domain // VO(DTO) 오브젝트 getter, setter 나누어줌 - 정보은닉
│   │   │       │   └── Dog.java
│   │   │       └── service // 비즈니스 로직 처리(domain 객체 조합 후 결과만들어 반환)
│   │   │           └── DogService.java
│   │   └── resources
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
  - controller
    - 
  - service
  - repository
  - api
  - config

- DTO(Data Transfer Object)
  - = VO(Value Object) // 값을 위해 쓰는 것
    - DTO는 인스턴스 개념이고 VO는 리터럴 값(을 흉내낸)개념
  - 데이터를 오브젝트로 변환하는 객체
  - Layer간(쉽게 한가지 예를 들자면, 서버 코딩 -> view 코딩)에 데이터를 넘길때는 DTO를 쓰면 편함
  -  데이터가 자동적으로 클래스화가 된다는 것
- Lombok 의 @DaTa를 적용하여 도메인 클래스에 getter/setter 생략 가능

- 과제를 다시 진행하면 어려웠던 것