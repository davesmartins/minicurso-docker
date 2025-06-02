
package com.example.imc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImcController {
    private final PessoaRepository repo;

    public ImcController(PessoaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pessoas", repo.findAll());
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Pessoa pessoa) {
        pessoa.setImc(pessoa.getPeso() / (pessoa.getAltura() * pessoa.getAltura()));
        repo.save(pessoa);
        return "redirect:/";
    }
}
