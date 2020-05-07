package br.fib.SpringBoot.facade;

import br.fib.SpringBoot.dto.AvaliacaoDTO;
import static br.fib.SpringBoot.conversor.AvaliacaoConversor.dtoToAvaliacao;

import br.fib.SpringBoot.models.Avaliacao;
import br.fib.SpringBoot.models.Livro;
import br.fib.SpringBoot.services.AvaliacaoService;
import br.fib.SpringBoot.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiFacade {

    @Autowired
    LivroService livroService;

    @Autowired
    AvaliacaoService avaliacaoService;

    public List<Livro> listaTodosLivros() {
        return livroService.listaTodosLivros();
    }

    public Long salvarLivro(Long idLivro, AvaliacaoDTO avaliacaoDTO) {
        Livro livro = livroService.buscaLivro(idLivro);
        Avaliacao avaliacao = dtoToAvaliacao(avaliacaoDTO, livro);
        return avaliacaoService.salvarAvaliacao(avaliacao);
    }
}
