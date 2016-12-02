package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Airplane;



public interface AirplaneRepository extends CrudRepository<Airplane,Integer> {
	 
}
