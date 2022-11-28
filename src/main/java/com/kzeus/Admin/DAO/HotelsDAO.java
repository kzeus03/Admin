package com.kzeus.Admin.DAO;
import java.util.List;
import com.kzeus.Admin.entity.Hotels;
public interface HotelsDAO {
	
	public List<Hotels> findAll(); //view all hotels
	public Hotels findById (int theId); //finding by id
	public void save(Hotels theHotels); //update
	public void deleteById(int theId); //delete by id
	
}
