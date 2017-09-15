package com.bank.web;

import com.bank.DateUtil;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.TransactionType;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;


@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("transactions", transactionService.getAll());
        return "transactions";
    }

    @PostMapping("/filter")
    public String filter(Model model, HttpServletRequest request) {
        LocalDate startDate = DateUtil.parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = DateUtil.parseLocalDate(request.getParameter("endDate"));

        model.addAttribute("transactions", transactionService.getBetween(startDate != null ? startDate : DateUtil.MIN_DATE,
                endDate != null ? endDate : DateUtil.MAX_DATE));
        return "/transactions";
    }

    @PostMapping
    public String addTransaction(@RequestParam(value = "accountFrom") String accountFrom,
                                 @RequestParam(value = "accountTo") String accountTo,
                                 @RequestParam("type") String type,
                                 @RequestParam("amount") String amount) {

        Account accFrom = accountFrom.isEmpty() ? accountService.get(Integer.valueOf(accountTo)) :
                accountService.get(Integer.valueOf(accountFrom));

        Account accTo = accountTo.isEmpty() ? accountService.get(Integer.valueOf(accountFrom)) :
                accountService.get(Integer.valueOf(accountTo));

        String txDescription = getTxDescription(accountFrom, accountTo);

        Double balanceIncrement = Double.valueOf(amount);
        accountService.updateBalance(accFrom.getId(), accTo.getId(), balanceIncrement, txDescription);


        Transaction transaction = new Transaction(null, balanceIncrement,
                Enum.valueOf(TransactionType.class, type), accTo, accFrom, txDescription);

        transactionService.save(transaction);

        return "redirect:/transactions";
    }

    private String getTxDescription(String accountFrom, String accountTo) {
        if (accountFrom.isEmpty() && !accountTo.isEmpty()) {
            return "Top Up";
        } else if (!accountFrom.isEmpty() && accountTo.isEmpty()) {
            return "Withdraw";
        }
        return "Transfer";
    }
}
