package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data; // 강아지 도메인 클래스에 getter/setter 생략을 위해 롬복 @DaTa를 적용합니다

@Data
public class Dog { // 강아지의 이름 및 견종을 담을 수 있는 도메인 클래스를 생성합니다
    private String name;
    private String kind;
}
