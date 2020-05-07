package br.fib.SpringBoot.services;

import br.fib.SpringBoot.exception.LivroNotFoundException;
import br.fib.SpringBoot.models.Avaliacao;
import br.fib.SpringBoot.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> listaAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Long salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao).getId();
    }

    public Avaliacao buscaAvaliacao(Long id) {
        return avaliacaoRepository.findById(id).orElseThrow(() -> new LivroNotFoundException());
    }

    public void excluirAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
