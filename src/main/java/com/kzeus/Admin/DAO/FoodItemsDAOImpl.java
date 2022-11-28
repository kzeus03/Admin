package com.kzeus.Admin.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kzeus.Admin.entity.FoodItems;

@Repository
public class FoodItemsDAOImpl implements FoodItemsDAO {

	private EntityManager entityManager;
	
	@Autowired
	public FoodItemsDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<FoodItems> Display() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<FoodItems> query = currentSession.createQuery("from FoodItems",FoodItems.class);
		List<FoodItems> food = query.getResultList();
		return food;
	}

}
