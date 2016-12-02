package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Airplane;
import boot.service.AirplaneService;



@Controller
public class AirPlaneController {

	@Autowired
	private AirplaneService airplaneService;
	
	@GetMapping("/airplanes")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "airplanes";
	}
	
	@GetMapping("/all-airplanes")
	public String allAirplanes(HttpServletRequest request) {
		request.setAttribute("airPlanes", airplaneService.findAll());
		request.setAttribute("mode", "MODE_AIRPLANES");
		return "airplanes";
	}
	
	@GetMapping("/new-airplane")
	public String newAirplane(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "airplanes";
	}

	
	@PostMapping("/save-airplane")
	public String saveAirplane(@ModelAttribute Airplane airplane, 
			BindingResult bindingResult, HttpServletRequest request) {
		airplaneService.save(airplane);
		request.setAttribute("airplanes", airplaneService.findAll());
		request.setAttribute("mode", "MODE_AIRPLANES");		
		return "airplanes";
	}
	
	@GetMapping("/update-airplane")
	public String updateAirplane(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("airplane", airplaneService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "airplanes";
	}	
	
	
	@GetMapping("/delete-airplane")
	public String deleteAirplane(@RequestParam int id, HttpServletRequest request) {
    airplaneService.delete(id);
	request.setAttribute("airplanes",airplaneService.findAll());
		request.setAttribute("mode", "MODE_AIRPLANES");
		return "airplanes";
	}
}
