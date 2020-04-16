package br.fib.SpringBoot.repository;

import br.fib.SpringBoot.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Long> {
}
