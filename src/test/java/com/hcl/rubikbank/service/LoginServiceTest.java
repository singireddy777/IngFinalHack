package com.hcl.rubikbank.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.rubikbank.dto.LoginResponseDto;
import com.hcl.rubikbank.entity.Customer;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.CustomerRepository;
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

@Mock CustomerRepository customerRepository;
@InjectMocks LoginServiceImpl loginService;
private static final Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);	
LoginResponseDto loginResponseDto;
Customer customer;

public Customer getCustomer() {
	
	Customer customer = new Customer();
	customer.setCustomerId(1);
customer.setCustomerName("ing");
customer.setMobileNumber("988894r9");

return customer;
}

public LoginResponseDto getLoginResponseDto() {
	LoginResponseDto loginResponseDto = new LoginResponseDto();
	loginResponseDto.setCustomerId(1);
	loginResponseDto.setMessage("login success");
	return loginResponseDto;	
}
@Before
public void setup() {
	customer = getCustomer();
	loginResponseDto = getLoginResponseDto();
}
@Test
public void loginTest() {
	logger.info("inside the loginTest in service");
	Mockito.when(customerRepository.findByCustomerId(Mockito.anyInt())).thenReturn(Optional.of(customer));
	LoginResponseDto response = loginService.userLogin(1);
	assertEquals("Customer Login success", response.getMessage());
}

@Test(expected = CommonException.class)
public void loginTest_1() {
	logger.info("inside the loginTest()_1 in service");
	 loginService.userLogin(1);
}
}
