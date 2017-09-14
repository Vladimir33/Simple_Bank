package com.bank.web;

import com.bank.model.Address;
import com.bank.model.AddressType;
import com.bank.model.Client;
import com.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RootController {

    @Autowired
    private ClientService service;

    @GetMapping("/")
    public String root() {
        return "redirect:clients";
    }

    @GetMapping("/clients")
    public String root(Model model) {
        model.addAttribute("clients", service.getAll());
//        if (id != null) {
//            model.addAttribute("edited", service.get(Integer.valueOf(id)));
//        }
        return "clients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:clients";
    }

    @PostMapping("/clients")
    public String addClient(@RequestParam("id") String id,
                            @RequestParam("name") String name,
                            @RequestParam("age") String age,
                            @RequestParam("city") String city,
                            @RequestParam("street") String street,
                            @RequestParam("type") String type,
                            @RequestParam("zipCode") String zipCode) {


        Client client = new Client(id.isEmpty() ? null : Integer.valueOf(id),
                name, Integer.valueOf(age),
                new Address(city, street, Enum.valueOf(AddressType.class, type), zipCode));

        service.save(client);

        return "redirect:/";
    }
}
