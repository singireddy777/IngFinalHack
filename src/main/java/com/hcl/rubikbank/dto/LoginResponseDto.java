package com.hcl.rubikbank.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String message;
	private Integer customerId;
}
