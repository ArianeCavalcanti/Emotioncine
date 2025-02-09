package com.senac.emotioncine.model;

/**
 *
 * @author arian
 */
public class Analise {

    private Long id;
    private Filme filme;
    private String comentario;
    private int nota;

    // Construtor vazio
    public Analise() {
    }

    // Construtor com parâmetros
    public Analise(Long id, Filme filme, String comentario, int nota) {
        this.id = id;
        this.filme = filme;
        this.comentario = comentario;
        this.nota = nota;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
