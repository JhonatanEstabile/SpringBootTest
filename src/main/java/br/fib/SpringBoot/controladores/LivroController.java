package br.fib.SpringBoot.controladores;

import br.fib.SpringBoot.models.*;
import br.fib.SpringBoot.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @Autowired
    AutorService autorService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("books/list");

        List<Livro> listaLivros = livroService.listaTodosLivros();
        modelAndView.addObject("livros", listaLivros);

        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Livro livro) {
        ModelAndView modelAndView = new ModelAndView("books/form");
        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("listaAutores", listaAutores);
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<Autor> listaAutores = autorService.listaAutores();
            return new ModelAndView("books/form", "listaAutores", listaAutores);
        }

        livroService.salvarLivro(livro);
        return new ModelAndView("redirect:/livros/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {

        Livro livro = livroService.buscaLivro(id);

        List<Autor> listaAutores = autorService.listaAutores();

        ModelAndView modelAndView = new ModelAndView("books/form");
        modelAndView.addObject("listaAutores", listaAutores);
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        livroService.excluiLivro(id);
        return new ModelAndView("redirect:/livros/list");
    }
}
