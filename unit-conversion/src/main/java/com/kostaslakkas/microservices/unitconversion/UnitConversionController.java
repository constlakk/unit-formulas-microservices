package com.kostaslakkas.microservices.unitconversion;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UnitConversionController {
	
	@Autowired
	private UnitFormulasProxy proxy;

	//Using ResponseEntity
	@GetMapping("unit-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public UnitConversion getConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> pathVariables = new HashMap<>();
		
		pathVariables.put("from", from);
		pathVariables.put("to", to);
		
		ResponseEntity<UnitConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/unit-formulas/from/{from}/to/{to}", UnitConversion.class, pathVariables);
		
		if(responseEntity == null) {
			
			throw new RuntimeException("Data not found for combination " + from + " and " + to);
			
		}
		
		UnitConversion unitConversion = responseEntity.getBody();
		
		return new UnitConversion(unitConversion.getId(), from, to, quantity, unitConversion.getMultiplyBy(), quantity.multiply(unitConversion.getMultiplyBy()));
		
	}
	
	
	//Using Feign
	@GetMapping("unit-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public UnitConversion getConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		UnitConversion unitConversion = proxy.getFormula(from, to);
		
		if(unitConversion == null) {
			
			throw new RuntimeException("Data not found for combination " + from + " and " + to);
			
		}
		
		return new UnitConversion(unitConversion.getId(), from, to, quantity, unitConversion.getMultiplyBy(), quantity.multiply(unitConversion.getMultiplyBy()));
		
	}	
	
}
