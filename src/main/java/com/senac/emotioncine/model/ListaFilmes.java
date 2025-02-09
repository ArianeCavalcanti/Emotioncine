package com.senac.emotioncine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ListaFilmes {
    private static List<Filme> filmes = new ArrayList<>();
    private static AtomicLong proximoId = new AtomicLong(1); // Gera IDs automaticamente

    public static void add(Filme filme) {
        filme.setId(proximoId.getAndIncrement()); // Define um ID único
        filmes.add(filme); // Adiciona à lista
    }

    public static List<Filme> getFilmes() {
        return filmes; // Retorna a lista de filmes cadastrados
    }

    public static Filme getFilmeById(long id) {
        return filmes.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }
}
