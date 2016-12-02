package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Account;



public interface AccountRepository extends CrudRepository<Account,Integer> {
	 
}
