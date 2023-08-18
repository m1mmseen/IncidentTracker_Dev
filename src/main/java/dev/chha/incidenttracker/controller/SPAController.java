package dev.chha.incidenttracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SPAController {
//
//    @RequestMapping({"/{path:[^\\.]*}"})
//    public RedirectView redirect() {
//        return new RedirectView("/");
//    }


    @RequestMapping({ "/{path:[^\\.]*}", "/**/{path:[^\\.]*}"})
    public String forward() {
        return "forward:/";
    }

}
