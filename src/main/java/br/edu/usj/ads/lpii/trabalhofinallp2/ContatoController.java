package br.edu.usj.ads.lpii.trabalhofinallp2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ContatoController {

    @GetMapping("/index-contato")
    public ModelAndView getContato() {
        ModelAndView mv = new ModelAndView("index-contato");
        return mv;
    }
}