package com.kzeus.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzeus.Admin.DAO.UsersDAO;
import com.kzeus.Admin.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersDAO usersDAO;
	
	@Autowired
	public UsersServiceImpl(UsersDAO theUsersDAO) {
		usersDAO=theUsersDAO;
	}
	
	
	
	@Override
	@Transactional
	public List<Users> findAll() {
		
		return usersDAO.findAll();
	}

	@Override
	@Transactional
	public Users findById(int userId) {
		
		return usersDAO.findById(userId);
	}

	@Override
	@Transactional
	public void save(Users theUsers) {
		usersDAO.save(theUsers);

	}

	@Override
	@Transactional
	public void deleteById(int userId) {
		usersDAO.deleteById(userId);

	}

}
