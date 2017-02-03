package com.sana.fare.dao.jpa;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sana.fare.domain.Fare;


/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
@Transactional
public interface IFareRepository extends CrudRepository<Fare, Long> {
}
