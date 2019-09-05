package com.hcl.rubikbank.util;

public class RubikConstants {

	private RubikConstants() {

	}

	// Error messages 
	public static final String ERROR_BANK_CODE_EXIST = "Bank code not exist";
	public static final String ERROR_NO_FAVOURITE_ACCOUNT = "No favourite account exists";
	public static final String ERROR_BANK_NOT_FOUND = "No bank account found";
	public static final String ADD_SUCCESS = "Added succesffully";
	public static final String ERROR_ACCOUNT_NAME_NOT_FOUND = "Account name doesn't exists";
	public static final String EDIT_SUCCESS = "Account details successfully updated in favorite accounts list.";
	public static final String CUSTOMER_ID_NOT_FOUND = "Invalid Customer Id.Please try again.";
	public static final String BANK_DETAILS_URL = "http://localhost:9090/bankdetails/api/bankDetails/";
	public static final String ERROR_IBAN_NUMBER="IBAN/Account Number should be 20 characters only";
	public static final String ERROR_BANK_NAME_EXIST="Bank not exist";

	public static final String FAVOURITES_NOT_FOUND = "No Favorite accounts are available";
	public static final String ERROR_NAME = "Only Letters/Numbers and 2 Special Characters[' and -] are allowed as valid inputs.";

}
