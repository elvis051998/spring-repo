package com.abm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abm.entity.Account;
import com.abm.exceptio.BankingException;
import com.abm.service.BankingService;

@Controller
public class BankingController {
	
	@Autowired
	private BankingService bankingService;
	
	@RequestMapping(value="/openAccount", method = RequestMethod.POST)
	public String openAccount(Account account, Map<String, Object> model) {
		
		try {
			int acno = bankingService.openAccount(account);
			model.put("result", acno);
			return "confirmation.jsp";
		}
		catch(BankingException e) {
			return "openAccount.jsp";
		}
		
		
		
	}
	
	@RequestMapping(value="/transfer")
	public String transfer(@RequestParam ("fromAcc") int fromAcc, @RequestParam ("toAcc") int toAcc, @RequestParam ("amount") int amount) {
		bankingService.transfer(fromAcc, toAcc, amount);
		
		return "openAccount.jsp";
	}
	
	@RequestMapping("/detail")
    public String detail(@RequestParam("accNo") int accNo, Map<String, Object> model) {
        try {
            Account account = bankingService.detail(accNo);
            model.put("AccountNumber", account);
            return "details.jsp";



       } catch (BankingException e) {
            return "openAccount.jsp";
        }

   }
}
