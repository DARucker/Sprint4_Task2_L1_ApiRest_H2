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

        /*Fruit fruit01 = Fruit.builder()
                .id(1)
                .nombre("Apple")
                .cantidadkilos(2)
                .build();

        fruitRepository.save(fruit01);

        Fruit found = fruitRepository.findByName(fruit01.getNombre());*/

        Fruit fruit02 = new Fruit(2, "banana", 10);
        Fruit found02 = fruitRepository.findByName(fruit02.getName());

        Assertions.assertTrue(found02.getName().equalsIgnoreCase("banana"));

    }
}
