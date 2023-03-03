package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fruit")
@Data @Builder
//@NoArgsConstructor
public class Fruit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotEmpty(message = "name cant be empty")
    String name;
    @Positive(message = "cuantity of kilos must be greather than 0")
    int cantidadkilos;

    public Fruit(int id, String name, int cantidadkilos) {
        this.id = id;
        this.name = name;
        this.cantidadkilos = cantidadkilos;
    }

    public Fruit(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidadkilos() {
        return cantidadkilos;
    }

    public void setCantidadkilos(int cantidadkilos) {
        this.cantidadkilos = cantidadkilos;
    }


}
