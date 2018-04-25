package com.qa.service;
import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;
public interface AccountingService {
	String getAllAccounts();
	String addAccount(String account);
	String updateAccount(Long id, String account);
	String deleteAccount(Long id);
}
