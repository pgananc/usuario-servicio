package com.nisum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedades {
	
	@Value("${password.pattern}")
	private String patternPassword;
	
	public String getPatternPassword() {
		return patternPassword;
	}
	public void setPatternPassword(String patternPassword) {
		this.patternPassword = patternPassword;
	}
}
