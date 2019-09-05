package com.hcl.rubikbank.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountResponseDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
}
