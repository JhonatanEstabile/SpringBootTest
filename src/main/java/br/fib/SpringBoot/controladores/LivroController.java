package br.fib.SpringBoot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("books/list");
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
