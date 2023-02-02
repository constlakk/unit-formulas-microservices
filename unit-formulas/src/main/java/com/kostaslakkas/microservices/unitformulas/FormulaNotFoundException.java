package com.kostaslakkas.microservices.unitformulas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FormulaNotFoundException extends RuntimeException {

	public FormulaNotFoundException(String msg) {
		
		super(msg);
		
	}
	
}
