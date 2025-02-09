package com.senac.emotioncine.controller;

import com.senac.emotioncine.model.Analise;
import com.senac.emotioncine.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/analises")
public class AnaliseController {

    private static final List<Analise> analises = new ArrayList<>();
    private static Long idCounter = 1L;

    @GetMapping("/novo")
    public String mostrarFormularioAnalise(@RequestParam(required = false) Long filmeId, Model model) {
        System.out.println("Recebendo requisição para /analises/novo com filmeId: " + filmeId);

        // Enviar lista de filmes para a página
        model.addAttribute("filmes", FilmeController.filmes);

        Filme filmeSelecionado = null;
        if (filmeId != null) {
            filmeSelecionado = FilmeController.filmes.stream()
                    .filter(f -> f.getId().equals(filmeId))
                    .findFirst()
                    .orElse(null);
        }

        model.addAttribute("filme", filmeSelecionado);
        model.addAttribute("analise", new Analise());

        System.out.println("Redirecionando para a página analise.html");
        return "analise"; // Página que exibe o formulário de análise
    }

    @GetMapping
    public String listarAnalises(Model model) {
        model.addAttribute("analises", analises);
        return "lista-analises"; // Página que exibe a lista de análises
    }

    @PostMapping("/novo")
    public String cadastrarAnalise(@RequestParam Long filmeId, @RequestParam String analise, @RequestParam int nota) {
        System.out.println("Cadastrando análise para o filme ID: " + filmeId); // Depuração

        Filme filme = FilmeController.filmes.stream()
                .filter(f -> f.getId().equals(filmeId))
                .findFirst()
                .orElse(null);

        if (filme != null) {
            Analise novaAnalise = new Analise(idCounter++, filme, analise, nota);
            analises.add(novaAnalise);
            System.out.println("Análise cadastrada com sucesso!");
        } else {
            System.out.println("Erro: Filme não encontrado!");
        }

        return "redirect:/analises"; // Redireciona para a lista de análises
    }
}
