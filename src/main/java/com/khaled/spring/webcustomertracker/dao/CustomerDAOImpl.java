package com.khaled.spring.webcustomertracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.khaled.spring.webcustomertracker.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//@Autowired
	//private SessionFactory sessionFactory;
	
	
	 @PersistenceContext
	    private EntityManager entityManager;

	 public List<Customer> getCustomers() {
	        Query<Customer> query =
	                (Query<Customer>) entityManager.createQuery("from Customer", Customer.class);

	        return query.getResultList();
	    }
	/*
	 * 
	 * 
	 * @Override
	public List<Customer> getCustomers() {
		System.out.println("CustomerDAOImpl : getCutomer");
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("CustomerDAOImpl : getCutomer after getting session ");

		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		System.out.println("CustomerDAOImpl : getCutomers after creating query");

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		System.out.println("CustomerDAOImpl : getCutomers after creating query");
				
		// return the results		
		return customers;
}
*/

		@Override
		public void saveCustomer(Customer theCustomer) {

			
			entityManager.merge(theCustomer);
		}

		@Override
		public Customer getCustomer(int theId) {
			return entityManager.find(Customer.class, theId);
		}

		@Override
		public void deleteCustomer(int theId) {
			// TODO Auto-generated method stub
			Customer c =entityManager.find(Customer.class, theId);
			entityManager.remove(c);
			
				}


	
}
