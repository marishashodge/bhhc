package com.bhhc.myapp.controller;


import com.bhhc.myapp.model.Reason;
import com.bhhc.myapp.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyAppController {

    @Autowired
    private ReasonRepository repository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value="name", required=true, defaultValue="Friend") String name, Model model) {

        // Add the name to the welcome message if passed in as a request param
        model.addAttribute("name", name);

        return "hello";
    }

    @GetMapping("/companies/{company}")
    public String company(@PathVariable("company") String company, Model model) {
        System.out.print("COMPANY");

        System.out.print(company);

        // Retrieve the reasons for the company that was passed into the path variable
        List<Reason> reasons = repository.findByCompany(company);

        System.out.print(reasons);


        if (reasons.size() >= 1) {
            model.addAttribute("company", company);
            model.addAttribute("reasons", reasons);

            return "company";
        }

        return "notFound";
    }

}
