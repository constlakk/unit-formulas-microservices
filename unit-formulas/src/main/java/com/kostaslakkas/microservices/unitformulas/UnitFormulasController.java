package com.kostaslakkas.microservices.unitformulas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitFormulasController {
	
	@Autowired
	private UnitFormulasRepository repository;
	
	@GetMapping("/unit-formulas")
	public List<UnitFormula> getAllFormulas(){
		
		return repository.findAll();
		
	}
	
	@GetMapping("/unit-formulas/from/{from}/to/{to}")
	public UnitFormula getFormula(@PathVariable String from, @PathVariable String to) {
		
		UnitFormula formula = repository.findByFromAndTo(from, to);
		
		if(formula == null) {
			
			throw new FormulaNotFoundException("Data not found for combination " + from + " and " + to);
			
		}
		
		return formula;
		
	}
	
	@PostMapping("/unit-formulas")
	public ResponseEntity<Object> addNewFormula(@RequestBody UnitFormula formula) {
		
		repository.save(formula);
		
		return ResponseEntity.created(null).build();
		
	}
	
	@DeleteMapping("/unit-formulas/{id}")
	public void deleteFormula(@PathVariable long id) {
		
		repository.deleteById(id);
		
	}

}
