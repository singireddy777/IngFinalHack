package com.hcl.rubikbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rubikbank.entity.BankData;

@Repository
public interface BankDataRepository extends JpaRepository<BankData, Integer> {

	BankData findByBankId(Integer bankId);

}
