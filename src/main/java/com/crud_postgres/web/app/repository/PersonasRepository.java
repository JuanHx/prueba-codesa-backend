package com.crud_postgres.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_postgres.web.app.model.Personas;

public interface PersonasRepository extends JpaRepository<Personas, Long>{
	
	List<Personas> findByDelete(Integer delete );

}
