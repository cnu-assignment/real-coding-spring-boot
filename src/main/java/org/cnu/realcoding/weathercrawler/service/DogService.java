package org.cnu.realcoding.weathercrawler.service;


import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // DogService에 @service 어노테이션을 추가합니다
public class DogService { // 메모리상의 자료구조를 사용하여 강아지 정보를 관리하는 DogService를 추가합니다
    private List<Dog> dogList = new ArrayList<>(); // DogService 클래스에 강아지 정보를 저장할 수 있는 List를 추가합니다

    public void insertDog(Dog dog) { // DogService의 dogList에 강아지를 새로 삽입하기 위한 메소드를 추가합니다
        dogList.add(dog);
    }

    public List<Dog> getAllDogs() { // DogService에 현재 저장된 모든 강아지 리스트를 반환하는 메서드를 추가합니다
        return dogList;
    }

    public Dog getDogByName(String name) { // DogService에 이름이 일치하는 강아지를 리턴하는 메서드를 추가합니다.
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(name)) {
                return target;
            }
        }
        return null;
    }

    public void updateDog(Dog dog) { // DogService에 이름이 일치하는 강아지를 업데이트 하기 위한 메서드를 추가
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(dog.getName())) {
                target.setKind(dog.getKind());
                break;
            }
        }
    }

    public void removeDog(String name) { // DogService에 이름과 일치하는 강아지를 삭제하기 위한 메서드를 추가합니다
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(name)) {
                dogList.remove(target);
                break;
            }
        }
    }
}
