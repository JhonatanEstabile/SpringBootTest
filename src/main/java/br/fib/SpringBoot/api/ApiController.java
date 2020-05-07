package br.fib.SpringBoot.api;

import br.fib.SpringBoot.dto.AvaliacaoDTO;
import static br.fib.SpringBoot.conversor.LivroConversor.toDTO;

import br.fib.SpringBoot.dto.LivroDTO;
import br.fib.SpringBoot.exception.LivroNotFoundException;
import br.fib.SpringBoot.facade.ApiFacade;
import br.fib.SpringBoot.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiFacade apiController;

    @GetMapping("/list")
    public ResponseEntity<List<LivroDTO>> list() {
        List<Livro> listaLivros = apiController.listaTodosLivros();
        return ResponseEntity.ok(toDTO(listaLivros));
    }

    @PostMapping("/livro/avaliacao/{id}")
    public ResponseEntity<Long> commntario(
            @PathVariable("id") Long id,
            @RequestBody AvaliacaoDTO avaliacaoDTO
    ) {
        try {
            return ResponseEntity.ok(apiController.salvarLivro(id, avaliacaoDTO));
        } catch (LivroNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
