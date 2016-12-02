package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import boot.model.Account;
import boot.model.Task;
import boot.dao.AccountRepository;
import boot.dao.TaskRepository;


@Service @Transactional
public class AccountService {
private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository){
		super();
		this.accountRepository= accountRepository;
	}
	
	public List <Account> findAll(){
		List<Account> accounts = new ArrayList<Account>();
		for(Account account : accountRepository.findAll() ){
			accounts.add(account);
		}
		return accounts;
	}
	
	
	public void save(Account account){
		accountRepository.save(account);
	}
	
	
	public void delete(int id){
		accountRepository.delete(id);
	}
	public  Account finOne(int id){
	return accountRepository.findOne(id);
	}
}
