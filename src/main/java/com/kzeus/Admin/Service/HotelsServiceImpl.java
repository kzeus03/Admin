package com.kzeus.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzeus.Admin.DAO.HotelsDAO;
import com.kzeus.Admin.entity.Hotels;

@Service
public class HotelsServiceImpl implements HotelsService {
	
	private HotelsDAO hotelsDAO;
	
	@Autowired
	public HotelsServiceImpl(HotelsDAO theHotlesDAO) {
		hotelsDAO=theHotlesDAO;
	}
	
	@Override
	@Transactional
	public List<Hotels> findAll() {
		
		return hotelsDAO.findAll();
	}

	@Override
	@Transactional
	public Hotels findById(int theId) {
		// TODO Auto-generated method stub
		return hotelsDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Hotels theHotles) {
		hotelsDAO.save(theHotles);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		hotelsDAO.deleteById(theId);

	}

}
