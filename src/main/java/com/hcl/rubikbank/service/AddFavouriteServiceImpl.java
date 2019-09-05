package com.hcl.rubikbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.rubikbank.dto.AddFavouriteRequestDto;
import com.hcl.rubikbank.dto.AddFavouriteResponseDto;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.FavouriteRepository;
import com.hcl.rubikbank.util.RubibankConstants;
import com.hcl.rubikbank.util.SmsSender;

/**
 * 
 * @author HariPriya G This class intended to adding the favourite details of
 *         customer
 *
 */
@Service
public class AddFavouriteServiceImpl implements AddFavouriteServcie {

	private static final Logger logger = LoggerFactory.getLogger(AddFavouriteServiceImpl.class);

	@Autowired
	FavouriteRepository favaouriteRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	SmsSender smsSender;

	/**
	 * 
	 * This method intended to adding the favourite details of customer
	 * 
	 * @param AddFavouriteRequestDto is the input object it contains
	 *                               accountName,bankName and bankCode
	 * @return it returns AddFavouriteResponseDto object with message
	 */

	@Override
	public AddFavouriteResponseDto addFaourite(AddFavouriteRequestDto addFavouriteRequestDto) {
		logger.info("Enter in add service impl");

		String bankNumber = addFavouriteRequestDto.getAccountNumber();
		if (bankNumber.length() != 20)
			throw new CommonException(RubibankConstants.ERROR_IBAN_NUMBER);

		Favourite favourite = new Favourite();
		favourite.setAccountName(addFavouriteRequestDto.getAccountName());
		favourite.setAccountNumber(bankNumber);
		favourite.setAccountStatus("1");
		favourite.setBankId(addFavouriteRequestDto.getBankId());
		favourite.setCustomerId(addFavouriteRequestDto.getCustomerId());
		favaouriteRepository.save(favourite);
		smsSender.sendSms(favourite);
		return new AddFavouriteResponseDto(RubibankConstants.ADD_SUCCESS);
	}

}
