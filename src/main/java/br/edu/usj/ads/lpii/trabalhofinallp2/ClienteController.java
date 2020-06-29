package br.edu.usj.ads.lpii.trabalhofinallp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/index-cliente")
    ModelAndView getListarCliente() {
        List<Cliente> listaCliente = clienteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index-cliente");
        modelAndView.addObject("listaCliente", listaCliente);
        return modelAndView;
    }

    @GetMapping(value = "/mostrar-cliente/{id}")
    ModelAndView getMostrarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar-cliente");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrar-cliente")
    ModelAndView getCadastrarCliente() {
        Cliente cliente = new Cliente();
        ModelAndView modelAndView = new ModelAndView("cadastrar-cliente");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrar-cliente")
    ModelAndView postCadastrarCliente(Cliente cliente) {
        Cliente cadastrarCliente = clienteRepository.save(cliente);
        ModelAndView modelAndView = new ModelAndView("mostrar-cliente");
        modelAndView.addObject("cliente", cadastrarCliente);
        return modelAndView;
    }

    @GetMapping(value = "/deletar-cliente/{id}")
    String getDeletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/index-cliente";

        // List<Cliente> lista = clienteRepository.findAll();
        // ModelAndView modelAndView = new ModelAndView("index");
        // modelAndView.addObject("lista", lista);
        // return modelAndView;
    }

    @GetMapping(value = "/editar-cliente/{id}")
    ModelAndView getEditarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrar-cliente");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

}