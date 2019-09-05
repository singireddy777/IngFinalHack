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
public class AddFavouriteRequestDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String accountNumber;
	private String bankName;
	private Integer customerId;
	private Integer bankId;
}
