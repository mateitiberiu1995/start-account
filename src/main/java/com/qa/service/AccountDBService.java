package com.qa.service;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

public class AccountDBService {
	
	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);      
		return "{\"message\": \"account sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account)
	{
		Account anAccount = util.getObjectForJSON(account, Account.class);
		Account idAccount = findAccount(id);
		if(account!=null)
		{
			idAccount = anAccount;
			manager.merge(idAccount);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id)
	{
		Account anAccount = findAccount(id);
		if(anAccount!=null)
		{
			manager.remove(id);
		}
		return "{\"message\": \"account sucessfully removed\"}";
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
