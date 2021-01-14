package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({ "/", "index", "index.html"})
    public String index(){
        int x = 1;
        System.out.println("inisde index controller" + x);
        return "index";
    }


    @RequestMapping("oups")
    public String oupsHandler() {

        return "notimplemented";
    }
}
