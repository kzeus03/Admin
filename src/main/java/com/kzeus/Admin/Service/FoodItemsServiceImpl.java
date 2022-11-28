package com.kzeus.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzeus.Admin.DAO.FoodItemsDAO;
import com.kzeus.Admin.entity.FoodItems;


@Service
public class FoodItemsServiceImpl implements FoodItemsService {

	private FoodItemsDAO foodItemsDAO;
	
	@Autowired
	public FoodItemsServiceImpl(FoodItemsDAO thefoodItemsDAO) {
		foodItemsDAO=thefoodItemsDAO;
	}
	
	@Override
	@Transactional
	public List<FoodItems> Display() {
		
		return foodItemsDAO.Display();
	}

}
