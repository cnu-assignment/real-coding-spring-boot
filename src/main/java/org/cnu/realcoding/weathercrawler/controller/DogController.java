package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.cnu.realcoding.weathercrawler.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // DogController 클래스에 @RestController 어노테이션을 추가합니다
public class DogController {
    @Autowired // Spring container가 DogController에서 사용하는 DogService 필드 변수에 객체를 injectio…
    private DogService dogService;

    @PostMapping("/dogs")
    public void insertDog(@RequestBody Dog dog) { // DogController에서 POST 방식의 /dogs endpoint를 노출합니다

        dogService.insertDog(dog); // DogController.insertDog() 에서 DogService 객체를 사용하여 강아지 정보를 삽입합니다
    }

    @GetMapping("/dogs") // DogService에 현재 저장된 모든 강아지 리스트를 반환하는 메서드를 추가합니다
    public List<Dog> getAllDogs() { // DogService에 현재 저장된 모든 강아지 리스트를 반환하는 메서드를 추가합니다
        return dogService.getAllDogs();
    }

    @GetMapping("/dogs/{name}") // DogController에 이름이 일치하는 강아지를 반환하기위한 PathVariable 방식의 GET method를 정의합니다
    public Dog getDogByName(@PathVariable String name) {
        return dogService.getDogByName(name);
    }

    @PutMapping("/dogs") // DogController에 강아지 정보를 업데이트 하기 위한 PUT 메서드를 정의합니다
    public void updateDog(@RequestBody Dog dog) {
        dogService.updateDog(dog);
    }

    @DeleteMapping("/dogs") // DogController에 이름과 일치하는 강아지를 삭제하기 위한 DELETE method를 정의합니다
    public void removeDog(@RequestParam String name) {
        dogService.removeDog(name);
    }
}
