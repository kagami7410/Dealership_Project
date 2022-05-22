package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
