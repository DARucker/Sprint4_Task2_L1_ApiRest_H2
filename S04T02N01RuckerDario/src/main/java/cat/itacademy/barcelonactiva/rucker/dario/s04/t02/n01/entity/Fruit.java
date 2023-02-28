package cat.itacademy.barcelonactiva.rucker.dario.s04.t02.n01.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fruta")
@Data @Builder
public class Fruit {

    public Fruit(int id, String name, int cantidadkilos) {
        this.id = id;
        this.name = name;
        this.cantidadkilos = cantidadkilos;
    }

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int cantidadkilos;
}