package exercicio5.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Numeros {
    private List<Integer> num;

    public Numeros() {
    }

    public Numeros(List<Integer> num) {
        this.num = num;
    }
}