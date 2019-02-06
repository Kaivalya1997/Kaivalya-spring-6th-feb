package com.sapient.order.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.sapient.order.rest.dto.Order;

@Component
public class OrderRepositoryImpl implements IOrderRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(Order order) throws Exception {
		entityManager.persist(order);

//		if (true)
		// throw new RuntimeException();
	}

	public void delete(int id) {
		// Order order1=entityManager.find(Order.class, id);
		 Order order1=new Order();
		 order1.setId(id);
		 entityManager.remove(entityManager.merge(order1));

	 }
	@Override
	public Order get(int id) {
        return entityManager.find(Order.class, id);
	}
	@Override
	public List<Order> getAll(){
		Query query= entityManager.createQuery("FROM Orders");
		List<Order> orders= query.getResultList();
		return orders;
	}
}