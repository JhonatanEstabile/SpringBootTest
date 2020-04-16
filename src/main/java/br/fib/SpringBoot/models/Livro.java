package br.fib.SpringBoot.models;

import javax.persistence.*;
import br.fib.SpringBoot.models.Autor;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "quantidade_paginas", nullable = false, unique = true)
    private int quantidadePaginas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setQuantidadePaginas(int quantidadePaginas)
    {
        this.quantidadePaginas = quantidadePaginas;
    }

    public int getQuantidadePaginas()
    {
        return this.quantidadePaginas;
    }
}