package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01;

import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity.Fruit;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.repository.FruitRepository;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service.FruitServiceImpl;
import cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.service.IFruitService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class FruitServiceMockTest {

    @Mock
    private FruitRepository fruitRepository;

    private IFruitService iFruitService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        iFruitService = new FruitServiceImpl(fruitRepository);

        Fruit fruit01 = Fruit.builder()
                .id(1)
                .name("peach")
                .cantidadkilos(4)
                .build();

        Mockito.when(fruitRepository.findById(1))
                .thenReturn(Optional.of(fruit01));

        Mockito.when(fruitRepository.save(fruit01))
                .thenReturn(fruit01);

    }
    @Test
    public void whenFindById_ThenReturnFruit(){
        Fruit found = iFruitService.getFruit(1);
        Assertions.assertThat(found.getName()).isEqualTo("apple");
    }
    @Test
    public void WhenUpdateCantKilos_ThenReturnNewCantKilos(){
        Fruit fruta = new Fruit(1, "apple", 20);
        Fruit newCantKilos = iFruitService.updateFruit(fruta);
        Assertions.assertThat(newCantKilos.getCantidadkilos()).isEqualTo(20);
    }


}
