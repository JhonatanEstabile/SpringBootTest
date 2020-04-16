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
}
