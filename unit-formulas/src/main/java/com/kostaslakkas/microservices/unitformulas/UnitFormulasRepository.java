package com.kostaslakkas.microservices.unitformulas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitFormulasRepository extends JpaRepository<UnitFormula, Long> {

	List<UnitFormula> findAll();
	
	UnitFormula findByFromAndTo(String from, String to);
	
	@SuppressWarnings("unchecked")
	UnitFormula save(UnitFormula formula);
	
	void deleteById(long id);
	
}
