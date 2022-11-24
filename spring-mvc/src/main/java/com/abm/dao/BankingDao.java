package com.abm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abm.entity.Account;
import com.abm.entity.Transaction;

@Repository
public class BankingDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public int add(Account account) {
		//entityManager.persist(account);
		Account updatedAccount = (Account) entityManager.merge(account);
		return updatedAccount.getAcno();
		
	}
	
	
	public Account fetch(int acno) {
		return entityManager.find(Account.class, acno);
	}
	
	public Transaction add(Transaction transaction) {
		return entityManager.merge(transaction);
	}
	
	public Account update(Account account) {
		Account updatedAccount = (Account) entityManager.merge(account);
		return updatedAccount;
		
	}


	public Account fetchDetail(int acNo) {
        return (Account)entityManager.createQuery("select distinct a from Account a join fetch a.transaction t where a.acno =:acNo")
                .setParameter("acNo", acNo)
                .getSingleResult();        
    }
}
