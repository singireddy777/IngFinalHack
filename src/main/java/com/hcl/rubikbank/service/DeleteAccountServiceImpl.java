package com.hcl.rubikbank.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rubikbank.dto.DeleteAccountResponseDto;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.FavouriteRepository;
import com.hcl.rubikbank.util.RubibankConstants;

@Service
public class DeleteAccountServiceImpl implements DeleteAccountService {

	@Autowired
	FavouriteRepository favouriteRepository;
	private static final Logger logger = LoggerFactory.getLogger(DeleteAccountServiceImpl.class);
	/**
	 * This method is use to delete (which is soft deletion)the favourite account number
	 * 
	 * @param customerId and  favouriteId are the input parameters.
	 * @return DeleteAccountResponseDto is the output parameter which contains
	 *         and message with status code.
	 * @exception  NO_CUSTOMER_FOUND_TO_DELETE if no account is found
	 */
	@Override
	public DeleteAccountResponseDto deleteAccounts(Integer favouriteId, Integer customerId) {
		DeleteAccountResponseDto deleteAccountResponseDto = new DeleteAccountResponseDto();
		logger.info("inside the deleteAccounts method in Service..");
		Optional<Favourite> favourite = favouriteRepository.findByFavouriteIdAndCustomerId(favouriteId, customerId);
		if (!favourite.isPresent())
			throw new CommonException(RubibankConstants.NO_CUSTOMER_FOUND_TO_DELETE);
		logger.info("inside the deleteAccounts method after condition check...");
		favourite.get().setAccountStatus("0");
		favouriteRepository.save(favourite.get());
		deleteAccountResponseDto.setMessage("Account deleted successfully from favorite accounts list");
		return deleteAccountResponseDto;
	}

}
