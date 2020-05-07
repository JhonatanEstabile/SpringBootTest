package br.fib.SpringBoot.repository;

import br.fib.SpringBoot.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository <Avaliacao, Long> {
}
