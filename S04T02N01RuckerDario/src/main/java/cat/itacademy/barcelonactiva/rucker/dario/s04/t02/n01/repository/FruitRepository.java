package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.repository;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository <Fruit, Integer> {

    Fruit findByName(String name);


}
