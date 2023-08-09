package exercicio5.demo.Controller;

import exercicio5.demo.Entity.Numeros;
import exercicio5.demo.Service.NumerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/conta")
public class NumeroController {

    @Autowired
    private NumerosService numerosService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Numeros numeros) {
        try {
            numerosService.cadastrar(numeros.getNum());
            return ResponseEntity.ok("Números cadastrados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar números: " + e.getMessage());
        }
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<String> calcularEstatisticas() {
        try {
            String estatisticas = numerosService.calcularEstatisticas();
            return ResponseEntity.ok(estatisticas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao calcular estatísticas: " + e.getMessage());
        }
    }
}
