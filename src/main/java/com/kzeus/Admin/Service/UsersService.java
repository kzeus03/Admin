package com.kzeus.Admin.Service;

import java.util.List;

import com.kzeus.Admin.entity.Users;

public interface UsersService {
	
	public List<Users> findAll();
	public Users findById(int userId);
	public void save(Users theUsers);
	public void deleteById(int userId);
}
