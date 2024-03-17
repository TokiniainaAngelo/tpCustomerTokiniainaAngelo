/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbds.tokiniaina.tpcustomertokiniainaangelo.service;

import com.mbds.tokiniaina.tpcustomertokiniainaangelo.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Façade pour gérer les Customers.
 *
 * @author xxxx
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Persist givent customer into db
     * @param customer 
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Get all customers from db
     * @return Customers
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    /**
     * Update customer
     * @param customer Customer
     * @return customer update
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

}
