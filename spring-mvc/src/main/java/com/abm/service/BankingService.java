package com.abm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.dao.BankingDao;
import com.abm.entity.Account;
import com.abm.entity.Transaction;
import com.abm.exceptio.BankingException;

@Service
@Transactional
public class BankingService {
	
	@Autowired
	private BankingDao bankinngDao;
	
	public int openAccount(Account account) throws BankingException {
		if(account.getBalance() >= 500)	
			return bankinngDao.add(account);
		else
			throw new BankingException("Cannot open account !");
	}
	
	public void transfer(int fromAcno, int toAcno, double amount) {
		Account fromaccount = bankinngDao.fetch(fromAcno);
		Account toaccount = bankinngDao.fetch(toAcno);
		
		fromaccount.setBalance(fromaccount.getBalance() - amount);
		toaccount.setBalance(toaccount.getBalance() - amount);
		
		bankinngDao.update(fromaccount);
		bankinngDao.update(toaccount);
		
		Transaction t1 = new Transaction();
		t1.setAccount(fromaccount);
		t1.setType("DEBIT");
		t1.setDate(LocalDate.now());
		t1.setAmount(amount);
		
		Transaction t2 = new Transaction();
		t2.setAccount(fromaccount);
		t2.setType("DEBIT");
		t2.setDate(LocalDate.now());
		t2.setAmount(amount);
		
		bankinngDao.add(t1);
		bankinngDao.add(t2);
		
	}
	
	public Account detail(int accNo) {
        return bankinngDao.fetchDetail(accNo);
    }
}
