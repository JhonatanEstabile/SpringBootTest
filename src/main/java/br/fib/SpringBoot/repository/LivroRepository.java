package br.fib.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fib.SpringBoot.models.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long> {
    @Query(value = " from #{#entityName} l left join fetch l.autor a order by l.nome desc ")
    List<Livro> listaLivros();
}
