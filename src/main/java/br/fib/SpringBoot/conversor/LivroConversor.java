package br.fib.SpringBoot.conversor;

import br.fib.SpringBoot.dto.LivroDTO;
import br.fib.SpringBoot.models.Livro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LivroConversor {
    public static LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setTitulo(livro.getNome());
        dto.setPaginas(livro.getQuantidadePaginas());
        dto.setAutor(livro.getAutor() != null ? livro.getAutor().getNome() : null);
        dto.setAvaliacoes(livro.getAvaliacoes().size() > 0
                ? AvaliacaoConversor.toDTO(livro.getAvaliacoes()): Arrays.asList());
        return dto;
    }

    public static List<LivroDTO> toDTO(List<Livro> livros) {
        return livros.stream().map(l -> toDTO(l)).collect(Collectors.toList());
    }
}
