package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.AirplaneRepository;
import boot.model.Airplane;



@Service @Transactional
public class AirplaneService {
	
	private final AirplaneRepository airplaneRepository;
	

	public AirplaneService(AirplaneRepository airplaneRepository){
		super();
		this.airplaneRepository= airplaneRepository;
	}
	
	public List <Airplane> findAll(){
		List<Airplane> airplanes = new ArrayList<Airplane>();
		for(Airplane airplane :airplaneRepository.findAll() ){
			airplanes.add(airplane);
		}
		return airplanes;
	}
	
	public void save(Airplane airplane){
		airplaneRepository.save(airplane);
	}
	
	public void delete(int id){
		airplaneRepository.delete(id);
	}
	
	public  Airplane finOne(int id){
	return airplaneRepository.findOne(id);
	}
}
