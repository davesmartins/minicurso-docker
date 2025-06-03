
package com.example.simulador;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class SimulacaoController {
    private final SimulacaoRepository repo;

    public SimulacaoController(SimulacaoRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/simular")
    public Map<String, Object> simular(@RequestBody Simulacao dados) {
        double parcela = dados.getValor() * Math.pow(1 + dados.getTaxa() / 100, dados.getMeses()) * (dados.getTaxa() / 100)
                / (Math.pow(1 + dados.getTaxa() / 100, dados.getMeses()) - 1);
        double total = parcela * dados.getMeses();
        dados.setParcela(parcela);
        dados.setTotal(total);
        repo.save(dados);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("parcela", String.format("%.2f", parcela));
        resultado.put("total", String.format("%.2f", total));
        return resultado;
    }

    @GetMapping("/historico")
    public List<Simulacao> historico() {
        return repo.findAll();
    }
}
