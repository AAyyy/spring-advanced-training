package com.asseco.aha.training.spring_advanced.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.asseco.aha.training.spring_advanced.jpa.domain.City;

public class CityServiceImpl implements CityService {

	private static final String JPQL = "select c from City c where c.state = ?1";

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asseco.aha.training.spring_advanced.jpa.repository.CityService#
	 * findByState(java.lang.String)
	 */
	public List<City> findByState(String state) {
		TypedQuery<City> query = em.createQuery(JPQL, City.class);
		query.setParameter(1, state);
		return query.getResultList();
	}

}
