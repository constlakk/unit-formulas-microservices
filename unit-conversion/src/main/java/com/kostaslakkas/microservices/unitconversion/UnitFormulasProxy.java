package com.kostaslakkas.microservices.unitconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="unit-formulas")
public interface UnitFormulasProxy {

	@GetMapping("/unit-formulas/from/{from}/to/{to}")
	public UnitConversion getFormula(@PathVariable String from, @PathVariable String to);
	
}
