package com.kzeus.Admin.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kzeus.Admin.entity.Hotels;
import com.kzeus.Admin.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private EntityManager entitymanager;
	
	@Autowired
	public UsersDAOImpl(EntityManager theEntityManager) {
		entitymanager=theEntityManager;
	}
	
	
	@Override
	public List<Users> findAll() {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Users> query=currentSession.createQuery("from Users",Users.class);
		List<Users> users=query.getResultList();
		return users;
	}

	@Override
	public Users findById(int userId) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Users users=currentSession.get(Users.class,userId );
		return users;
	}

	@Override
	public void save(Users theUsers) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUsers);

	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<Users> query=currentSession.createQuery("delete from Users where id=:userid");
		query.setParameter("userid", theId);
		query.executeUpdate();
	}

}
