package br.fib.SpringBoot.services;

import br.fib.SpringBoot.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.fib.SpringBoot.models.Autor;
import br.fib.SpringBoot.repository.AutorRepository;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listaAutores() {
        return autorRepository.findAll();
    }

    public void salvarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public Autor buscaAutor(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void excluiAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
