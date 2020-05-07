package br.fib.SpringBoot.services;

import br.fib.SpringBoot.models.Livro;
import br.fib.SpringBoot.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listaTodosLivros() {
        return livroRepository.findAll();
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro buscaLivro(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void excluiLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
