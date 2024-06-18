package com.product.info.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.ShopperInfo;

public interface ShopInfoRepository extends JpaRepository<ShopperInfo, Long> {

	Optional<ShopperInfo> findByshopperId(String shopperId);

}
