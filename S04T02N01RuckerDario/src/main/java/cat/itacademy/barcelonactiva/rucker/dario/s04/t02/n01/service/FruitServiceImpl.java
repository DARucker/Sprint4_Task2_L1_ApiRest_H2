package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FruitServiceImpl implements IFruitService {



    //@Autowired
    private final FruitRepository fruitRepository;

    @Override
    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit fruitDB = getFruit(fruit.getId());
            if(null == fruitDB){
                return null;
            }

        fruitDB.setName(fruit.getName());
        fruitDB.setCantidadkilos(fruit.getCantidadkilos());
        return fruitRepository.save(fruitDB);
    }

    @Override
    public void deleteFruit(int id) {

        Fruit fruitToDelete = fruitRepository.findById(id).get();
        fruitRepository.delete(fruitToDelete);

    }

    @Override
    public Fruit getFruit(int id) {
        return fruitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fruit> allFruit() {
        return fruitRepository.findAll();
    }

    /**
     * This method is out of scope but was create only for testing porpose
     * @param name
     * @return Fruit if found
     */
    @Override
    public Fruit findByName(String name) {
        return null;
    }
}
