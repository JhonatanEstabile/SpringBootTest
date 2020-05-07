package br.fib.SpringBoot.conversor;

import br.fib.SpringBoot.dto.AvaliacaoDTO;
import br.fib.SpringBoot.models.Avaliacao;
import br.fib.SpringBoot.models.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoConversor {
    public static Avaliacao dtoToAvaliacao(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setComentario(avaliacaoDTO.getComentario());
        avaliacao.setNota(avaliacaoDTO.getNota());

        return avaliacao;
    }

    public static Avaliacao dtoToAvaliacao(AvaliacaoDTO avaliacaoDTO, Livro livro) {
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setComentario(avaliacaoDTO.getComentario());
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setLivro(livro);

        return avaliacao;
    }

    public static AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();

        dto.setComentario(avaliacao.getComentario());
        dto.setNota(avaliacao.getNota());

        return dto;
    }

    public static List<AvaliacaoDTO> toDTO(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream().map(a -> toDTO(a)).collect(Collectors.toList());
    }
}
