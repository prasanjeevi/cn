package com.cloudnative.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value="SELECT * FROM ORDERS ORDER BY ORDERED_ON DESC LIMIT 3", nativeQuery = true)
    Iterable<Order> recentOrders();
}
