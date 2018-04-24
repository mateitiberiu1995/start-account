package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

public class AccountService {

	@Inject
	private Map<Long, Account> accountMap;

	@Inject
	private JSONUtil util;

	/*public AccountService() {
		accountMap = new HashMap<Integer, Account>();
	}*/
	
	public String getAllAccounts()
	{
		return util.getJSONForObject(accountMap);
	}
	
	public String addAccount(String account) {
		Account anAccount = util.getObjectForJSON(account , Account.class);
		if(accountMap.containsValue(anAccount))
		{
			return "{\"message\": \"account is already in the database\"}";
		}
		else
		{
		accountMap.put((long) (accountMap.size()+1), anAccount);
		return "{\"message\": \"account sucessfully added\"}";
		}
		
	}
	
	public String updateAccount(Long id, String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		if(accountMap.containsKey(id))
		{
			accountMap.replace(id, anAccount);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		else
			return "{\"message\": \"account couldn't be updated\"}";
		
	}
	
	public String deleteAccount(Long id)
	{
		if(accountMap.containsKey(id))
		{
			accountMap.remove(id);
			return "{\"message\": \"account sucessfully removed\"}";
		}
		else
			return "{\"message\": \"account couldn't be removed\"}";
		
	}
	/*public void addAccountFromMap(Account userAccount) {
		accountMap.put(count, userAccount);
		
		count++;
	}

	public void removeAccountFromMap(Integer accountToRemove) {
		boolean countExists = accountMap.containsKey(accountToRemove);
		if (countExists) {
			accountMap.remove(accountToRemove);
		}
	}

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public int getNumberOfAccountWithFirstName(String firstNameOfAccount) {
		return (int) accountMap.values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(firstNameOfAccount)).count();
	}*/

}
