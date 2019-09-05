package com.hcl.rubikbank.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.rubikbank.entity.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

	public Optional<Favourite>findByFavouriteIdAndCustomerId(Integer favouriteId, Integer customerId);
	public Optional<Favourite> findByFavouriteId(Integer favouriteId);
	@Query("select f from Favourite f where f.accountStatus=1")
	Page<Favourite> findAll(Pageable pageable);
}
