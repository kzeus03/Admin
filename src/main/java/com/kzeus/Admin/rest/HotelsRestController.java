package com.kzeus.Admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kzeus.Admin.Service.FoodItemsService;
import com.kzeus.Admin.Service.HotelsService;
import com.kzeus.Admin.entity.FoodItems;
import com.kzeus.Admin.entity.Hotels;

@RestController
@RequestMapping("/api")
public class HotelsRestController {

	// inject employee DAO directly (ill-advised manner)
	private HotelsService hotelsService;
	private FoodItemsService foodItemsService;

	@Autowired // constructor injection
	public HotelsRestController(HotelsService theHotelsService,FoodItemsService theFoodItemsService) {
		hotelsService = theHotelsService;
		foodItemsService=theFoodItemsService;
	}

	@GetMapping("/hotels") // read all employees
	public List<Hotels> findAll() {
		return hotelsService.findAll();
	}

	// read single hotel
	@GetMapping("/hotels/{hotelsId}")
	public Hotels getHotel(@PathVariable int hotelsId) {
		Hotels hotel = hotelsService.findById(hotelsId);
		if(hotel==null) {
			throw new RuntimeException("Hotel not found");
		}
		return hotel;
	}
	
	//view food items	
	@GetMapping("/hotels/{hotelsId}/food")
	public List<FoodItems> Display(){
		return foodItemsService.Display();
	}
	
	//add new hotel
	@PostMapping("/hotels")
	public Hotels CreateHotels(@RequestBody Hotels theHotels) {
		theHotels.setId(0);
		hotelsService.save(theHotels);
		return theHotels;
	}
	
	//update existing hotel details 
	@PutMapping("/hotels")
	public Hotels updateEmployee(@RequestBody Hotels theHotels) {
		hotelsService.save(theHotels);
		return theHotels;
	}
	
	//delete employee
	@DeleteMapping("/hotels/{hotelsId}")
	public String deleteEmployee(@PathVariable int hotelsId) {
		Hotels tempHotel=hotelsService.findById(hotelsId);
		if(tempHotel==null) {
			throw new RuntimeException("Hotel not found");
		}
		hotelsService.deleteById(hotelsId);
		return "Employee with hotelId "+hotelsId+" is deleted";
	}
	
}
