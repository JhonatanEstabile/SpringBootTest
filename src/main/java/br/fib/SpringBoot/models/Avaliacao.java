package br.fib.SpringBoot.models;

import javax.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "comentario", nullable = true, unique = false)
    private String comentario;

    @Column(name = "nota", nullable = false, unique = false)
    private int nota;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
