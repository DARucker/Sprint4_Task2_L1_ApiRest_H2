package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.controller;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/fruit")
public class    FruitController {
    /*
   http://localhost:8080/fruta/add

http://localhost:8080/fruta/update

http://localhost:8080/fruta/delete/{id}

http://localhost:8080/fruta/getOne/{id}

http://localhost:8080/fruta/getAll ** DONE **
     */

    @Autowired
    IFruitService fruitService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Fruit>> getAllFruit(){
        List<Fruit> allFruit = fruitService.allFruit();
        if(allFruit.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allFruit);
    }


}
