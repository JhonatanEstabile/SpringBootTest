package br.fib.SpringBoot.services;

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
}
