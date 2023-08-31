package exercicio5.demo;
import exercicio5.demo.Service.NumerosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TesteNumeros {
        private NumerosService numerosService;

        @Before

        public void setUp() {
            numerosService = new NumerosService();
        }

        @Test
        public void TesteCalcularMedia() {
            numerosService.cadastrar(List.of(1, 2, 3, 4, 5));
            double media = numerosService.calcularMedia();
            Assert.assertEquals(3.0, media, 0.001);
        }

        @Test
        public void TesteCalcularMediaListaVazia() {
            double media = numerosService.calcularMedia();
            Assert.assertEquals(0.0, media, 0.001);
        }

        @Test
        public void TesteCalcularDesvioPadrao() {
            numerosService.cadastrar(List.of(1, 2, 3, 4, 5));
            double desvioPadrao = numerosService.calcularDesvioPadrao();
            Assert.assertEquals(1.4142135623730951, desvioPadrao, 0.001);
        }

        @Test
        public void TesteCalcularDesvioPadraoListaVazia() {
            double desvioPadrao = numerosService.calcularDesvioPadrao();
            Assert.assertEquals(0.0, desvioPadrao, 0.001);
        }

        @Test
        public void TesteCalcularMedianaListaVazia() {
            double mediana = numerosService.calcularMediana();
            Assert.assertEquals(0.0, mediana, 0.001);
        }
    @Test
    public void TesteValorMaximo() {
        numerosService.cadastrar(List.of(1, 5, 3, 2, 4));
        String estatisticas = numerosService.calcularEstatisticas();
        String expected = "Média: 3.0\nDesvio Padrão: 1.4142135623730951\nMediana: 3.0";
        Assert.assertEquals(expected, estatisticas);
    }

    @Test
    public void TesteValorMinimo() {
        numerosService.cadastrar(List.of(5, 4, 3, 2, 1));
        String estatisticas = numerosService.calcularEstatisticas();
        String expected = "Média: 3.0\nDesvio Padrão: 1.4142135623730951\nMediana: 3.0";
        Assert.assertEquals(expected, estatisticas);
    }

}
