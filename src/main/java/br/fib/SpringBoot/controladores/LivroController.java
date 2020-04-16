package br.fib.SpringBoot.controladores;

import br.fib.SpringBoot.models.Livro;
import br.fib.SpringBoot.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView =  new ModelAndView("books/list");

        List<Livro> listaLivros = livroService.listaTodosLivros();
        modelAndView.addObject("livros", listaLivros);

        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        return new ModelAndView("books/form");
    }

    @PostMapping("/gravar")
    public String gravar() {
        return "Olá Spring Boot";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        return new ModelAndView("books/alterar");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        return new ModelAndView("redirect:/livro/list");
    }
}
