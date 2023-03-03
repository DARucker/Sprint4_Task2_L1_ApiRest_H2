package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.controller;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service.IFruitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value =  "/fruit")
public class    FruitController {
    /*
http://localhost:8080/fruta/add ** DONE

http://localhost:8080/fruta/update/{id} ** DONE

http://localhost:8080/fruta/delete/{id} ** DONE

http://localhost:8080/fruta/getOne/{id} ** DONE

http://localhost:8080/fruta/getAll ** DONE **
     */

    @Autowired
    IFruitService fruitService;

    private static Logger LOG = LoggerFactory.getLogger(FruitController.class);

    @PostMapping (value = "/add")
    public ResponseEntity<Fruit> createFruit(@Valid @RequestBody Fruit fruit, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
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

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Fruit> upDateFruit(@PathVariable ("id") int id, @RequestBody Fruit fruit){
        fruit.setId(id);
        Fruit fruitDB = fruitService.updateFruit(fruit);
        if(fruitDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fruitDB);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteFruit(@PathVariable ("id") int id){
        LOG.info("Using method delete");
        Fruit fruitDelete = fruitService.getFruit(id);
        if(fruitDelete == null){
            return ResponseEntity.notFound().build();
        }
        fruitService.deleteFruit(fruitDelete.getId());
        return ResponseEntity.ok(fruitDelete);
    }
    private String formatMessage (BindingResult result){

        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString ="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }

}
