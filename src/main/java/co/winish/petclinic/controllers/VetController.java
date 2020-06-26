package co.winish.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    @GetMapping(path = {"", "/", "/index", "/index.html"})
    public String listVets(Model model) {
        return "vets/index";
    }
}
