package br.edu.usj.ads.lpii.trabalhofinallp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping(value = "/index-game")
    ModelAndView getListarGame() {
        List<Game> listaGame = gameRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index-game");
        modelAndView.addObject("listaGame", listaGame);
        return modelAndView;
    }

    @GetMapping(value = "/mostrar-game/{id}")
    ModelAndView getMostrarGame(@PathVariable Long id) {
        Game game = gameRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar-game");
        modelAndView.addObject("game", game);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrar-game")
    ModelAndView getCadastrarGame() {
        Game game = new Game();
        ModelAndView modelAndView = new ModelAndView("cadastrar-game");
        modelAndView.addObject("game", game);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrar-game")
    ModelAndView postCadastrarGame(Game game) {
        Game cadastrarGame = gameRepository.save(game);
        ModelAndView modelAndView = new ModelAndView("mostrar-game");
        modelAndView.addObject("game", cadastrarGame);
        return modelAndView;
    }

    @GetMapping(value = "/deletar-game/{id}")
    String getDeletarGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
        return "redirect:/index-game";

        // List<Produto> lista = produtoRepository.findAll();
        // ModelAndView modelAndView = new ModelAndView("index");
        // modelAndView.addObject("lista", lista);
        // return modelAndView;
    }

    @GetMapping(value = "/editar-game/{id}")
    ModelAndView getEditarGame(@PathVariable Long id) {
        Game game = gameRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrar-game");
        modelAndView.addObject("game", game);
        return modelAndView;
    }

}