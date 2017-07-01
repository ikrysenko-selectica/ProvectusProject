package edu.provectus.repositories.impl;

import edu.provectus.model.Order;
import edu.provectus.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order add(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public void delete(Order order) {
        entityManager.createNativeQuery("DELETE FROM BUYER_ORDER WHERE ID = ?1")
                .setParameter(1, order.getId())
                .executeUpdate();
    }

    @Override
    public Order getById(int id) {
        return entityManager.find(Order.class, id);
    }
}
