package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.repository.FruitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FruitRepositoryMockTest {

    @Autowired
    private FruitRepository fruitRepository;

    @Test
    public void whenFindByName_theReturnFruit(){

/*        Fruit fruit01 = Fruit.builder()
                .id(1)
                .name("Apple")
                .cantidadkilos(2)
                .build();
        fruitRepository.save(fruit01);
        Fruit found01 = fruitRepository.findByName("Apple");*/

        Fruit fruit02 = new Fruit(2, "banana", 10);
        fruitRepository.save(fruit02);
        Fruit found02 = fruitRepository.findByName("banana");

        Assertions.assertTrue(found02.getName().equalsIgnoreCase("banana"));
        //Assertions.assertTrue(found02.getName().equalsIgnoreCase("naranja"));

    }
    @Test
    public void whenFindById_theReturnFruit(){
        Fruit fruit03 = new Fruit(3, "banana", 10);
        fruitRepository.save(fruit03);
        Fruit found03 = fruitRepository.findById(1).get();
        Assertions.assertTrue(found03.getName().equalsIgnoreCase("banana"));

    }


}
