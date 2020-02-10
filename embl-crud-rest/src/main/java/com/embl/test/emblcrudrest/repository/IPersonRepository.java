package com.embl.test.emblcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.embl.test.emblcrudrest.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
