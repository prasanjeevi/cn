package com.cloudnative.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    
    @Query(value="SELECT P.*,COUNT(1) AS SALE FROM PRODUCT P, ORDERS O WHERE P.ID=O.PRODUCT_ID GROUP BY P.ID ORDER BY SALE DESC LIMIT 3", nativeQuery = true)
    Iterable<Product> topProducts();
}
