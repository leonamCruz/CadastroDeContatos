package tech.leonam.microservico.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        //Encaminhe para uma página de erro, ou a sua página principal.
        return "redirect:https://leonam.tech";
    }
}
