package de.resistome.resistomedb.controllers;


import de.resistome.resistomedb.webmodel.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ResistomeDbController {

    @GetMapping("/")
    public String showForm(SearchForm personForm) {
        return "/";
    }

    @PostMapping("/")
    public String buildQueryAndLaunch(@Valid SearchForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/";
        }

        //TODO launch the query

        return "redirect:/results";
    }

    //TODO
}
