package com.bank.web;

import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.service.AccountService;
import com.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String getAll(Model model, @RequestParam("id") String id) {

        model.addAttribute("client", clientService.get(Integer.valueOf(id)));
        model.addAttribute("accounts", accountService.getAll(Integer.valueOf(id)));
        return "accounts";
    }

    @PostMapping
    public String addAccount(@RequestParam("id") String id,
                             @RequestParam("clientId") String clientId,
                             @RequestParam("description") String description,
                             @RequestParam("type") String type,
                             RedirectAttributes redirectAttributes) {

        Account account = new Account(id.isEmpty() ? null : Integer.valueOf(id),
                clientService.get(Integer.valueOf(clientId)), description,
                Enum.valueOf(AccountType.class, type));

        accountService.save(account);

        redirectAttributes.addAttribute("id", clientId);

        return "redirect:accounts";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id,
                         @RequestParam("clientId") String clientId,
                         RedirectAttributes redirectAttributes){

        accountService.delete(Integer.valueOf(id));
        redirectAttributes.addAttribute("id", clientId);

        return "redirect:/accounts";
    }
}
