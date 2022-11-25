package com.abm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Account;
import com.abm.service.BankingService;

@RestController
public class BankingRestController {

    @Autowired
    private BankingService bankingService;
    
    @RequestMapping("/banking")
    public Account details(@RequestParam("acno") int acno) {
            Account account3 = bankingService.detail(acno);
            return account3;
    }

}
