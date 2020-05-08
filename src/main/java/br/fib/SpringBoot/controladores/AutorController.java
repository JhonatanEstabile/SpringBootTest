package br.fib.SpringBoot.controladores;

import br.fib.SpringBoot.models.Autor;
import br.fib.SpringBoot.models.Livro;
import br.fib.SpringBoot.services.AutorService;
import br.fib.SpringBoot.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("authors/list");

        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("authors", listaAutores);

        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Autor autor) {
        ModelAndView modelAndView = new ModelAndView("authors/form");
        return modelAndView;
    }

    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Autor autor, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("authors/form");
        }

        autorService.salvarAutor(autor);
        return new ModelAndView("redirect:/autor/list");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {

        Autor autor = autorService.buscaAutor(id);

        ModelAndView modelAndView = new ModelAndView("authors/form");
        modelAndView.addObject("autor", autor);

        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        autorService.excluiAutor(id);
        return new ModelAndView("redirect:/autor/list");
    }
}
