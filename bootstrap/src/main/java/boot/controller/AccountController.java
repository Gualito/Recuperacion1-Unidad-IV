package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Account;

import boot.service.AccountService;



@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "accounts";
	}

	@GetMapping("/all-accounts")
	public String allAccounts(HttpServletRequest request) {
		request.setAttribute("accounts", accountService.findAll());
		request.setAttribute("mode", "MODE_ACCOUNTS");
		return "accounts";
	}

	@GetMapping("/new-account")
	public String newAccount(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "accounts";
	}

	
	@PostMapping("/save-account")
	public String saveAccount(@ModelAttribute Account account, 
			BindingResult bindingResult, HttpServletRequest request) {
		accountService.save(account);
		request.setAttribute("accounts", accountService.findAll());
		request.setAttribute("mode", "MODE_ACCOUNTS");		
		return "accounts";
	}
	
	@GetMapping("/update-account")
	public String updateAccount(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("account", accountService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "accounts";
	}	
	
	
	@GetMapping("/delete-account")
	public String deleteAccount(@RequestParam int id, HttpServletRequest request) {
		
    accountService.delete(id);
	request.setAttribute("accounts", accountService.findAll());
		request.setAttribute("mode", "MODE_ACCOUNTS");
		return "accounts";
	}	

}
