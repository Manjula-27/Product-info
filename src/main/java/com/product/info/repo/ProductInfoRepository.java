package com.product.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.ProductInfo;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

}
