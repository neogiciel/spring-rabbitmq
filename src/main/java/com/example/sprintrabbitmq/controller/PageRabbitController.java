package com.example.sprintrabbitmq.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sprintrabbitmq.model.Message;
import com.example.sprintrabbitmq.service.BddManager;
import com.example.sprintrabbitmq.util.Trace;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;


@Controller
//@RequestMapping("/page")
public class PageRabbitController {

    //BddManager
    @Autowired
    BddManager bdd;

    @GetMapping
    @RequestMapping("/page/rabbit")
    public String page(Model model) {
        

        //bdd.addMessageSQL(new Message("Test"));
        //bdd.addMessage(new Message("Test"));
        List<Message> liste = bdd.getListMessages();
        int nb = liste.size();
        model.addAttribute("msg", "Nb Message = "+ nb);
        model.addAttribute("liste", liste);
        return "pagerabbit";
    }


  
}
