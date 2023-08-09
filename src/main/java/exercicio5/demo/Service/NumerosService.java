package exercicio5.demo.Service;

import exercicio5.demo.Entity.Numeros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NumerosService {

    private List<Integer> numeros = new ArrayList<>();
    public void cadastrar(List<Integer> numeros) {
        this.numeros.addAll(numeros);
    }
    public double calcularMedia() {
        return calcularMedia(numeros);
    }

    public double calcularDesvioPadrao() {
        return calcularDesvioPadrao(numeros);
    }








    private double calcularMedia(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        return (double) soma / numeros.size();
    }

    private double calcularDesvioPadrao(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }

        double media = calcularMedia(numeros);

        double somaDiferencasQuadradas = 0.0;

        for (int numero : numeros) {
            double diferenca = numero - media;
            somaDiferencasQuadradas += diferenca * diferenca;
        }

        double variancia = somaDiferencasQuadradas / numeros.size();

        return Math.sqrt(variancia);
    }

    public double calcularMediana() {
        if (numeros.isEmpty()) {
            return 0.0;
        }

        List<Integer> sortedNumeros = new ArrayList<>(numeros);
        Collections.sort(sortedNumeros);

        int tamanho = sortedNumeros.size();
        if (tamanho % 2 == 0) {
            int meio1 = sortedNumeros.get(tamanho / 2 - 1);
            int meio2 = sortedNumeros.get(tamanho / 2);
            return (double) (meio1 + meio2) / 2;
        } else {
            return sortedNumeros.get(tamanho / 2);
        }
    }

    public String calcularEstatisticas() {
        double media = calcularMedia();
        double desvioPadrao = calcularDesvioPadrao();
        double mediana = calcularMediana();

        String mensagem = "Média: " + media + "\nDesvio Padrão: " + desvioPadrao + "\nMediana: " + mediana;

        return mensagem;
    }
}
