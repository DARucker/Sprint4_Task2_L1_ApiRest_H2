package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.controller;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service.IFruitService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/fruit")
public class    FruitController {
    /*
   http://localhost:8080/fruta/add ** DONE

http://localhost:8080/fruta/update/{id}

http://localhost:8080/fruta/delete/{id}

http://localhost:8080/fruta/getOne/{id} **

http://localhost:8080/fruta/getAll ** DONE **
     */

    @Autowired
    IFruitService fruitService;

    private static Logger LOG = LoggerFactory.getLogger(FruitController.class);






    @PostMapping (value = "/add")
    public ResponseEntity<Fruit> createFruit(@Valid @RequestBody Fruit fruit){
        LOG.info("Using method createFruit");

        Fruit fruitCreate = fruitService.createFruit(fruit);

        return ResponseEntity.status(HttpStatus.CREATED).body(fruit);
    }

    @GetMapping(value = "getOne/{id}")
    public ResponseEntity<Fruit> getFruit(@PathVariable int id){
        LOG.info("Using method getFruit");
        Fruit fruit = fruitService.getFruit(id);
        if(null == fruit){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fruit);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Fruit>> getAllFruit(){
        LOG.info("Using method getAll to list every item on DB");
        List<Fruit> allFruit = fruitService.allFruit();
        if(allFruit.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allFruit);
    }

    public ResponseEntity<Fruit> upDateFruit(int id, Fruit fruit){


    }

}
