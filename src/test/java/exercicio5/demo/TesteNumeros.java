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
        public void TesteCalcularMedianaListaImpar() {
            numerosService.cadastrar(List.of(1, 3, 2, 5, 4));
            double mediana = numerosService.calcularMediana();
            Assert.assertEquals(3.0, mediana, 0.001);
        }

        @Test
        public void TesteCalcularMedianaListaPar() {
            numerosService.cadastrar(List.of(1, 3, 2, 5, 4, 6));
            double mediana = numerosService.calcularMediana();
            Assert.assertEquals(3.5, mediana, 0.001);
        }

        @Test
        public void TesteCalcularMedianaListaVazia() {
            double mediana = numerosService.calcularMediana();
            Assert.assertEquals(0.0, mediana, 0.001);
        }


}
