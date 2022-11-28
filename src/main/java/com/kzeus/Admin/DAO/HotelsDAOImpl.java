package com.kzeus.Admin.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kzeus.Admin.entity.Hotels;

@Repository
public class HotelsDAOImpl implements HotelsDAO {

	// define field for entity manager
	private EntityManager entitymanager;

	// set up constructor injection
	@Autowired
	public HotelsDAOImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
	}

	@Override
	public List<Hotels> findAll() {

		// get the current hibernate session
		Session currentSession = entitymanager.unwrap(Session.class);

		// create a query
		Query<Hotels> query = currentSession.createQuery("from Hotels", Hotels.class);

		// execute the query and get result
		List<Hotels> hotels = query.getResultList();

		// return the results
		return hotels;

	}

	@Override
	public Hotels findById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		Hotels theHotels=currentSession.get(Hotels.class, theId);
		return theHotels;
	}

	@Override
	public void save(Hotels theHotels) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		currentSession.saveOrUpdate(theHotels);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		Query<Hotels> query=currentSession.createQuery("delete from Hotels where id=:HotelId");
		query.setParameter("HotelId", theId);
		query.executeUpdate();
	}

}
