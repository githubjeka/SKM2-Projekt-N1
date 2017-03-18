package com.web.controller;

import com.base.dao.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {


    @Autowired
    AddressDAO address;


    @RequestMapping(value = "/123", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Привет, Ваня!");
        return "Ivan";

    }

    @RequestMapping(value = "/hello/{name:.+}")
    public ModelAndView hello(@PathVariable("name") String name) {

        ModelAndView model = new ModelAndView();
        model.setViewName("Ivan");
        model.addObject("message", name);

        return model;
    }

    @RequestMapping(value = "/allAddress")
    public ModelAndView showAllAddress() throws Exception {
        ModelAndView mav = new ModelAndView("allAddress");
        mav.addObject("allAddresses", address.getAllAddress());
        return mav;

    }
}
