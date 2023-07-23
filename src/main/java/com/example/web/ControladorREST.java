package com.example.web;

import com.example.domain.Individuo;
import lombok.extern.slf4j.Slf4j;
import com.example.servicio.IndividuoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorREST {

    @Autowired

    private IndividuoServicio individuoServicio;

    @GetMapping("/")
    public String comienzo(Model model) {

        List<Individuo> individuos = individuoServicio.listaIndividuos();
        //List individuos = Arrays.asList(individuo, individuo2);

        log.info("Estoy ejecutando el controlador MVC");
        model.addAttribute("individuos", individuos);
        return "indice";
    }

    @GetMapping("/anexar")
    public String anexar(Individuo individuo) {

        return "cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(Individuo individuo) {
        individuoServicio.salvar(individuo);
        return "redirect:/";
    }
    
    @GetMapping("/cambiar/{id_individuo}")
    public String cambiar(Individuo individuo, Model model) {
        individuo = individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo",individuo);
        return "cambiar";
    }
    
    @GetMapping("/borrar")
    public String borrar(Individuo individuo) {
        individuoServicio.borrar(individuo);
        
        return "redirect:/";
    }
}
