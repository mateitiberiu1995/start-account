package com.qa.application;

import javax.persistence.*;

import com.qa.domain.Account;
import com.qa.service.AccountDBService;
import com.qa.service.AccountService;
import com.qa.util.JSONUtil;

public class App {
	
	public static void main(String[] args) {
		AccountService service = new AccountService();
		JSONUtil util = new JSONUtil();
		Account joeBloggs = new Account("Joe", "Bloggs", "1238");
		Account janeBloggs = new Account("Jane", "Bloggs", "1239");
		service.addAccountFromMap(joeBloggs);
		service.addAccountFromMap(janeBloggs);
		String mapAsJSON = util.getJSONForObject(service.getAccountMap());
		System.out.println("This is the account map as JSON " + mapAsJSON);
	}

}
