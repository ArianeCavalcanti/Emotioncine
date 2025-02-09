package com.senac.emotioncine.controller;

import com.senac.emotioncine.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    static final List<Filme> filmes = new ArrayList<>();
    private static Long idCounter = 1L;

    // Página inicial
    @GetMapping
    public String home() {
        return "index"; 
    }

    // Página para listar filmes
    @GetMapping("/lista")
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmes);
        return "lista-filmes"; 
    }

    // Exibir o formulário de cadastro de filmes
    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "filme";
    }

    // Processar o formulário de cadastro de filmes
    @PostMapping("/novo")
    public String cadastrarFilme(@ModelAttribute Filme filme) {
        filme.setId(idCounter++); // Gera um ID único para o filme
        filmes.add(filme); // Adiciona à lista
        return "redirect:/analises/novo?filmeId=" + filme.getId(); // Redireciona para adicionar análise
    }
}

